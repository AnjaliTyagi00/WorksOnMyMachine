document.addEventListener("DOMContentLoaded", function () {
  // Dummy data for meetings
  const meetings = [
    {
      id: 1,
      room: "Conference Room A",
      date: "2024-08-25",
      time: "10:00 AM",
      duration: "2 hours",
      amenities: ["Projector", "Whiteboard"],
      image: "image2.jpg",
    },
    {
      id: 2,
      room: "Meeting Room A",
      date: "2024-08-26",
      time: "1:00 PM",
      duration: "3 hours",
      amenities: ["Conference Call", "Water Dispenser"],
      image: "image3.webp",
    },
    {
      id: 3,
      room: "Board Room 1",
      date: "2024-08-27",
      time: "9:00 AM",
      duration: "1 hour",
      amenities: ["TV", "Whiteboard"],
      image: "image2.jpg",
    },
    {
      id: 4,
      room: "Conference Room A",
      date: "2024-08-25",
      time: "10:00 AM",
      duration: "2 hours",
      amenities: ["Projector", "Whiteboard"],
      image: "image2.jpg",
    },
    {
      id: 5,
      room: "Meeting Room A",
      date: "2024-08-26",
      time: "1:00 PM",
      duration: "3 hours",
      amenities: ["Conference Call", "Water Dispenser"],
      image: "image3.webp",
    },
    {
      id: 6,
      room: "Board Room 1",
      date: "2024-08-27",
      time: "9:00 AM",
      duration: "1 hour",
      amenities: ["TV", "Whiteboard"],
      image: "image2.jpg",
    },
  ];

  // Get the meeting ID from the URL parameters
  const urlParams = new URLSearchParams(window.location.search);
  const meetingId = parseInt(urlParams.get("id"));

  // Find the meeting by ID
  const meeting = meetings.find((m) => m.id === meetingId);

  if (meeting) {
    // Populate the form with the meeting data
    document.getElementById("meetingRoom").value = meeting.room;
    document.getElementById("meetingDate").value = meeting.date;
    const convertedTime = convertTo24HourFormat(meeting.time);
    console.log("Converted Time:", convertedTime);
    document.getElementById("meetingTime").value = convertedTime;
    document.getElementById("meetingDuration").value = parseInt(
      meeting.duration
    );

    // Check the amenities checkboxes
    meeting.amenities.forEach((amenity) => {
      const checkbox = document.querySelector(
        `input[name="amenities"][value="${amenity}"]`
      );
      if (checkbox) {
        checkbox.checked = true;
      }
    });

    // Handle form submission
    document
      .getElementById("editMeetingForm")
      .addEventListener("submit", function (event) {
        event.preventDefault(); // Prevent the form from submitting normally

        // Update the meeting data with the new values
        meeting.room = document.getElementById("meetingRoom").value;
        meeting.date = document.getElementById("meetingDate").value;
        meeting.time = document.getElementById("meetingTime").value;
        meeting.duration = `${
          document.getElementById("meetingDuration").value
        } hours`;

        const selectedAmenities = [];
        document
          .querySelectorAll('input[name="amenities"]:checked')
          .forEach((checkbox) => {
            selectedAmenities.push(checkbox.value);
          });
        meeting.amenities = selectedAmenities;

        // Log updated meeting data (or send it to the server)
        console.log("Updated meeting:", meeting);

        // Optionally, redirect to the meeting overview page or show a success message
        alert("Meeting updated successfully!");
        window.location.href = "editMeetingPageOne.html";
      });
  } else {
    alert("Meeting not found!");
  }
});


function convertTo24HourFormat(timeStr) {
    const [time, modifier] = timeStr.split(' ');

    let [hours, minutes] = time.split(':');

    if (hours === '12') {
        hours = '00';
    }

    if (modifier === 'PM') {
        hours = parseInt(hours, 10) + 12;
    }

    return `${hours.padStart(2, '0')}:${minutes}`;
}
