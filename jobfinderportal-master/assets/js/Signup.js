document.addEventListener("DOMContentLoaded", function() {
    const signupForm = document.getElementById("signup-form");
    const loginForm = document.getElementById("login-form");
  
    signupForm.addEventListener("submit", function(event) {
      event.preventDefault();
      const formData = new FormData(signupForm);
      const data = Object.fromEntries(formData.entries());
      
      axios.post('http://127.0.0.1:8000/users/signup', data) // Updated endpoint URL
        .then(function(response) {
          console.log(response.data);
          // Handle success, maybe redirect to a new page
        })
        .catch(function(error) {
          console.error(error);
          // Handle error, maybe display an error message to the user
        });
    });
  
    loginForm.addEventListener("submit", function(event) {
      event.preventDefault();
      const formData = new FormData(loginForm);
      const data = Object.fromEntries(formData.entries());
      
      axios.post('http://127.0.0.1:8000/login', data) // Update this endpoint URL if needed
        .then(function(response) {
          console.log(response.data);
          // Handle success, maybe redirect to a new page
        })
        .catch(function(error) {
          console.error(error);
          // Handle error, maybe display an error message to the user
        });
    });
});
