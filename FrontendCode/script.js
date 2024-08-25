document.addEventListener('DOMContentLoaded', function() {
    // Example: Adding an event listener to handle navigation clicks

    const homeLink = document.querySelector('nav a[href="index.html"]');
    const loginLink = document.querySelector('nav a[href="login.html"]');
    const contactLink = document.querySelector('nav a[href="contact.html"]');
    const mainContent = document.getElementById('mainContent');

    // Event listener for Home link
    homeLink.addEventListener('click', function(event) {
        event.preventDefault();
        mainContent.innerHTML = `
            <section id="homePage">
                <h1>Welcome to the Meeting Room Booking System</h1>
                <p>Book meeting rooms with ease based on your requirements.</p>
            </section>
        `;
    });

    // Event listener for Login link
    loginLink.addEventListener('click', function(event) {
        event.preventDefault();
        window.location.href = 'login.html';
    });

    // Event listener for Contact link
    contactLink.addEventListener('click', function(event) {
        event.preventDefault();
        window.location.href = 'contact.html';
    });

    // You can add more event listeners as needed for different interactions
});
