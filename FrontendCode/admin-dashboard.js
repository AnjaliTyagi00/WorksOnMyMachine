document.addEventListener("DOMContentLoaded", function() {
    const createRoomBtn = document.getElementById("createRoomBtn");
    const manageRoomsBtn = document.getElementById("manageRoomsBtn");

    const createRoomForm = document.getElementById("createRoomForm");
    const manageRoomsSection = document.getElementById("manageRooms");

    // Handle the Create Room button click
    createRoomBtn.addEventListener("click", function() {
        // Redirect to the createRoom.html page
        window.location.href = "createRoom.html";
    });

    // Handle the Manage Rooms button click
    manageRoomsBtn.addEventListener("click", function() {
        // Hide the create room form if it is visible
        createRoomForm.style.display = "none";

        // Toggle the visibility of the manage rooms section
        if (manageRoomsSection.style.display === "none" || manageRoomsSection.style.display === "") {
            manageRoomsSection.style.display = "block";
        } else {
            manageRoomsSection.style.display = "none";
        }
    });
});
