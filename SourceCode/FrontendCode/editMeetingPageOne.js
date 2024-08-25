document.addEventListener("DOMContentLoaded", function() {
    const meetingsContainer = document.getElementById('meetingsContainer');

    // Dummy data for meetings
    const meetings = [
        {
            id: 1,
            room: "Conference Room A",
            date: "2024-08-25",
            time: "10:00 AM",
            duration: "2 hours",
            amenities: ["Projector", "Whiteboard"],
            image: "image2.jpg"
        },
        {
            id: 2,
            room: "Meeting Room A",
            date: "2024-08-26",
            time: "1:00 PM",
            duration: "3 hours",
            amenities: ["Conference Call", "Water Dispenser"],
            image: "image3.webp"
        },
        {
            id: 3,
            room: "Board Room 1",
            date: "2024-08-27",
            time: "9:00 AM",
            duration: "1 hour",
            amenities: ["TV", "Whiteboard"],
            image: "image2.jpg"
        },
        {
            id: 4,
            room: "Conference Room A",
            date: "2024-08-25",
            time: "10:00 AM",
            duration: "2 hours",
            amenities: ["Projector", "Whiteboard"],
            image: "image2.jpg"
        },
        {
            id: 5,
            room: "Meeting Room A",
            date: "2024-08-26",
            time: "1:00 PM",
            duration: "3 hours",
            amenities: ["Conference Call", "Water Dispenser"],
            image: "image3.webp"
        },
        {
            id: 6,
            room: "Board Room 1",
            date: "2024-08-27",
            time: "9:00 AM",
            duration: "1 hour",
            amenities: ["TV", "Whiteboard"],
            image: "image2.jpg"
        }
    ];

    // Create cards dynamically
    meetings.forEach(meeting => {
        const card = document.createElement('div');
        card.className = 'card cardCustom';

        card.innerHTML = `
            <img src="${meeting.image}" class="card-img-top mw-25 "  alt="${meeting.room}">
            <div class="card-body">
                <h5 class="card-title">${meeting.room}</h5>
                <p class="card-text"><strong>Date:</strong> ${meeting.date}</p>
                <p class="card-text"><strong>Time:</strong> ${meeting.time}</p>
                <p class="card-text"><strong>Duration:</strong> ${meeting.duration}</p>
                <p class="card-text"><strong>Amenities:</strong> ${meeting.amenities.join(', ')}</p>
                <a href="editMeetingPageTwo.html?id=${meeting.id}" class="btn btn-primary">Edit Meeting</a>
            </div>
        `;

        meetingsContainer.appendChild(card);
    });
});
