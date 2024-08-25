document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    const forgotPasswordLink = document.querySelector('.forgot-password a');

    loginForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submission behavior

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const role = document.getElementById('role').value;

        // Dummy login validation for demonstration purposes
        // Replace this logic with actual authentication in a real application
        if (username && password) {
            // Simulating different redirects based on the user's role
            if (role === 'admin') {
                window.location.href = 'admin-dashboard.html';
            } else if (role === 'manager') {
                window.location.href = 'manager.html';
            } else if (role === 'member') {
                window.location.href = 'member.html';
            } else {
                alert('Invalid role selected.');
            }
        } else {
            alert('Please enter both username and password.');
        }
    });

    // Event listener for "Forgot Password?" link
    forgotPasswordLink.addEventListener('click', function(event) {
        event.preventDefault(); // Prevent the default link behavior

        const email = prompt("Please enter your email address:");
        if (email) {
            // Implement password reset logic here, e.g., sending an AJAX request to the server
            // For now, just display a confirmation message
            alert(`If the email ${email} is associated with an account, a password reset link will be sent.`);
        } else {
            alert('Email address is required to reset your password.');
        }
    });
});