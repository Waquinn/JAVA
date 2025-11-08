// Parking data storage
const parkedVehicles = [];
let currentCheckoutIndex = -1;

// Initialize with current time
window.onload = function () {
    const now = new Date();
    document.getElementById('checkoutTime').value = now.toISOString().slice(0, 16);
};

// Modal control functions
function showModal(id) {
    document.getElementById(id).classList.remove('hidden');
}

function hideModal(id) {
    document.getElementById(id).classList.add('hidden');
}

function showAddVehicleModal() {
    showModal('addVehicleModal');
}

function showCheckoutModal() {
    if (parkedVehicles.length === 0) {
        alert("No vehicles to checkout");
        return;
    }

    const checkoutList = document.getElementById('checkoutVehicleList');
    checkoutList.innerHTML = parkedVehicles.map((vehicle, index) => 
        `<div>
            <input type="radio" name="checkoutVehicle" id="vehicle-${index}" value="${index}" ${index === 0 ? 'checked' : ''}>
            <label for="vehicle-${index}">
                ${vehicle.type} (Parked at: ${vehicle.entryTime.toLocaleTimeString()})
            </label>
        </div>`
    ).join('');

    showModal('checkoutModal');
}

// Vehicle management functions
function addVehicle() {
    const type = document.getElementById('newVehicleType').value;
    const entryTime = new Date();

    parkedVehicles.push({
        type: type === 'regular' ? 'Regular Vehicle' : 'Motorcycle',
        entryTime: entryTime,
        isOvernight: false
    });

    hideModal('addVehicleModal');
    updateVehicleList();
    showModal('overnightModal');
}

function processCheckout() {
    const checkoutTime = new Date(document.getElementById('checkoutTime').value);
    const selectedVehicle = document.querySelector('input[name="checkoutVehicle"]:checked');

    if (!selectedVehicle) {
        alert("Please select a vehicle to checkout");
        return;
    }

    const index = parseInt(selectedVehicle.value);
    const vehicle = parkedVehicles[index];

    // Calculate duration in hours
    const durationMs = checkoutTime - vehicle.entryTime;
    const durationHours = durationMs / (1000 * 60 * 60);

    // Calculate fee
    let fee = 0;
    let breakdown = "";

    if (vehicle.type === 'Regular Vehicle') {
        if (durationHours <= 3) {
            fee = 50;
            breakdown = "First 3 hours: ₱50";
        } else {
            const extraHours = Math.ceil(durationHours - 3);
            fee = 50 + (extraHours * 20);
            breakdown = `First 3 hours: ₱50\nAdditional ${extraHours} hours: ₱${extraHours * 20}`;
        }
    } else { // Motorcycle
        if (durationHours <= 3) {
            fee = 20;
            breakdown = "First 3 hours: ₱20";
        } else {
            const extraHours = Math.ceil(durationHours - 3);
            fee = 20 + (extraHours * 10);
            breakdown = `First 3 hours: ₱20\nAdditional ${extraHours} hours: ₱${extraHours * 10}`;
        }
    }

    // Check for overnight penalty
    if (checkoutTime.getHours() >= 22 || checkoutTime.getHours() < 6) {
        const penalty = vehicle.type === 'Regular Vehicle' ? 250 : 100;
        fee += penalty;
        breakdown += `\nOvernight penalty: ₱${penalty}`;
    }

    // Display final fee
    document.getElementById('feeAmount').textContent = fee.toFixed(2);
    document.getElementById('feeBreakdown').innerHTML = breakdown.replace(/\n/g, '<br>');
    document.getElementById('parkingDuration').textContent = `Total Parking Time: ${durationHours.toFixed(2)} hours`;

    // Remove vehicle from list
    parkedVehicles.splice(index, 1);
    updateVehicleList();
    hideModal('checkoutModal');

    document.getElementById('finalFeeText').textContent = `Vehicle checked out. Final fee: ₱${fee.toFixed(2)}`;
    showModal('finalFeeModal');
}

function updateVehicleList() {
    const vehicleList = document.getElementById('parkedVehiclesList');

    if (parkedVehicles.length === 0) {
        vehicleList.innerHTML = "No vehicles currently parked";
        return;
    }

    vehicleList.innerHTML = parkedVehicles.map(vehicle => 
        `<div class="parked-vehicle">
            ${vehicle.type} - Parked at ${vehicle.entryTime.toLocaleTimeString()}
        </div>`
    ).join('');
}

function handleOvernightChoice(needsOvernight) {
    if (parkedVehicles.length > 0) {
        parkedVehicles[parkedVehicles.length - 1].isOvernight = needsOvernight;
    }
    hideModal('overnightModal');
}
