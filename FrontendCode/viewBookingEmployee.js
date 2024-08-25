document.addEventListener("DOMContentLoaded", function () {
  // Example data; replace this with data fetched from your server or database
  const meetings = [
    {
      room: "Conference Room A",
      date: "2024-08-24",
      time: "10:00 AM",
      duration: "2 hours",
      amenities: "Projector, Whiteboard",
      image: "image2.jpg", // Replace with the path to your image
    },
    {
      room: "Meeting Room B",
      date: "2024-08-25",
      time: "2:00 PM",
      duration: "1 hour",
      amenities: "TV, Conference Call",
      image: "image3.webp", // Replace with the path to your image
    },
    {
      room: "Conference Room A",
      date: "2024-08-24",
      time: "10:00 AM",
      duration: "2 hours",
      amenities: "Projector, Whiteboard",
      image: "image2.jpg", // Replace with the path to your image
    },
    {
      room: "Meeting Room B",
      date: "2024-08-25",
      time: "2:00 PM",
      duration: "1 hour",
      amenities: "TV, Conference Call",
      image: "image3.webp", // Replace with the path to your image
    },
    {
      room: "Meeting Room B",
      date: "2024-08-25",
      time: "2:00 PM",
      duration: "1 hour",
      amenities: "TV, Conference Call",
      image: "image3.webp", // Replace with the path to your image
    },
    {
      room: "Conference Room A",
      date: "2024-08-24",
      time: "10:00 AM",
      duration: "2 hours",
      amenities: "Projector, Whiteboard",
      image: "image2.jpg", // Replace with the path to your image
    },
  ];

  const meetingsContainer = document.getElementById("meetingsContainer");

  meetings.forEach((meeting) => {
    const card = document.createElement("div");
    card.className = "card";

    card.innerHTML = `
            <img src="${meeting.image}" class="card-img-top" alt="${meeting.room}">
            <div class="card-body">
                <h5 class="card-title">${meeting.room}</h5>
                <p class="card-text"><strong>Date:</strong> ${meeting.date}</p>
                <p class="card-text"><strong>Time:</strong> ${meeting.time}</p>
                <p class="card-text"><strong>Duration:</strong> ${meeting.duration}</p>
                <p class="card-text"><strong>Amenities:</strong> ${meeting.amenities}</p>
            </div>
        `;

    meetingsContainer.appendChild(card);
  });
});
