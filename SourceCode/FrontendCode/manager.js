document.addEventListener('DOMContentLoaded', function () {
    const managerCredits = 2000; // This is a static value for now, can be fetched dynamically from a backend

    // Update the credits display
    const creditsElement = document.getElementById('managerCredits');
    creditsElement.textContent = managerCredits;

    // Form elements
    const organizeMeetingForm = document.getElementById('organizeMeetingForm');
    const scheduleView = document.getElementById('scheduleView');
    const organizeMeetingBtn = document.getElementById('organizeMeetingBtn');
    const viewScheduleLink = document.getElementById('viewScheduleLink');
    const organizeMeetingLink = document.getElementById('organizeMeetingLink');

    // Function to show or hide the form
    function toggleForm(formToShow, formToHide) {
        formToShow.style.display = 'block';
        formToHide.style.display = 'none';
    }

    // Organize Meeting Button Click
    organizeMeetingBtn.addEventListener('click', function() {
        toggleForm(organizeMeetingForm, scheduleView);
    });

    // View Schedule Link Click
    viewScheduleLink.addEventListener('click', function() {
        toggleForm(scheduleView, organizeMeetingForm);
    });

    // Organize Meeting Link Click in Sidebar
    organizeMeetingLink.addEventListener('click', function(event) {
        event.preventDefault(); // Prevent default link behavior
        toggleForm(organizeMeetingForm, scheduleView);
    });
});
