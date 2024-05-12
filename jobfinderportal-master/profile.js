        const id = sessionStorage.getItem('id');
        // Fetch profile data from the backend
        async function fetchProfileData() {

            try {
                const response = await axios.get(`http://localhost:8081/form1/user/${id}`) // Replace '/api/profile' with your actual backend API endpoint
                const profileData = response.data;
                console.log(id);
                console.log(profileData);

                // Update HTML elements with fetched data
                document.querySelector('.profile-name').innerText = profileData.name;
                document.querySelector('.profile-title').innerText = profileData.title;
                document.querySelector('.profile-location').innerText = profileData.location;
                document.querySelector('.profile-status').innerText = profileData.status;
                document.querySelector('.bio-card').innerText = profileData.bio;
                // You can update other elements similarly with other properties from profileData
            } catch (error) {
                console.error('Error fetching profile data:', error);
            }
        }

        // Call fetchProfileData function when the page loads
        window.onload = fetchProfileData;

        // Function to fetch and display skills when the page is opened
async function displaySkills() {
    try {
        // Make a GET request to fetch skills from backend
        const response = await axios.get(`http://localhost:8081/skills/user/${id}`);

        // Get the skills array from the response
        const skills = response.data;

        // Get the ul element where skills will be appended
        const skillsList = document.getElementById('skills-list');

        // Clear existing list items
        skillsList.innerHTML = '';

        // Append each skill to the list
        skills.forEach(function(skill) {
            const li = document.createElement('li');
            li.textContent = skill.name;
            skillsList.appendChild(li);
        });
    } catch (error) {
        console.error('Error fetching skills:', error);
    }
}

// Call the function when the page is opened
document.addEventListener('DOMContentLoaded', displaySkills);



// Function to fetch and display work history when the page is opened
async function displayWorkHistory() {
    try {
        // Make a GET request to fetch work history from backend
        const response = await axios.get(`http://localhost:8081/api/work-history/find/${id}`);
        console.log(response.data)
        // Get the work history array from the response
        const workHistory = response.data;

        // Get the element where work history will be appended
        const workHistoryDiv = document.getElementById('work-history');

        // Clear existing content
        workHistoryDiv.innerHTML = '';

        // Iterate over each work history item and create HTML elements
        workHistory.forEach(function(item) {
            const workItemDiv = document.createElement('div');
            workItemDiv.classList.add('work-item');

            const h3 = document.createElement('h3');
            h3.textContent = item.position;
            workItemDiv.appendChild(h3);

            const workIconDiv = document.createElement('div');
            workIconDiv.classList.add('work-icon');

            const editIconSpan = document.createElement('span');
            editIconSpan.classList.add('edi-icon');
            editIconSpan.innerHTML = '<i class="fas fa-edit fa-lg" style="cursor: pointer;"></i>';
            workIconDiv.appendChild(editIconSpan);

            const deleteIconSpan = document.createElement('span');
            deleteIconSpan.classList.add('delete-icon');
            deleteIconSpan.innerHTML = '<i class="fas fa-trash-alt fa-lg" style="cursor: pointer;"></i>';
            workIconDiv.appendChild(deleteIconSpan);

            workItemDiv.appendChild(workIconDiv);

            const startDate = item.from_date;
            const endDate = item.to_date ;

            const p1 = document.createElement('p');
            p1.textContent = startDate +"  -  " +endDate;
            workItemDiv.appendChild(p1);

            const p2 = document.createElement('p');
            p2.textContent = item.work_desc;
            workItemDiv.appendChild(p2);

            workHistoryDiv.appendChild(workItemDiv);
        });
    } catch (error) {
        console.error('Error fetching work history:', error);
    }
}

// Call the function when the page is opened
document.addEventListener('DOMContentLoaded', displayWorkHistory);


async function fetchEducationData() {
    try {
        // Make GET request to your backend API endpoint
        const response = await axios.get(`http://localhost:8081/api/education-history/find/${id}`);

        // Return the education data from the response
        return response.data;
    } catch (error) {
        console.error('Error fetching education data:', error);
        return []; // Return an empty array if there's an error
    }
}

// Function to populate education data into HTML
async function populateEducationData() {
    const educationContainer = document.querySelector('.profile-education');

    // Fetch education data
    const educationData = await fetchEducationData();

    // Clear existing content
    educationContainer.innerHTML = '';

    // Iterate over each education item and create HTML elements
    educationData.forEach(education => {
        const educationItem = document.createElement('div');
        educationItem.classList.add('education-item');

        // Create HTML elements for each education item
        const title = document.createElement('h3');
        title.textContent = education.degree;
        const university = document.createElement('p');
        university.textContent = education.university;
        const graduationDate = document.createElement('p');
        graduationDate.textContent = `Graduated in ${education.gradYear}`;
        const cgpa = document.createElement('p');
        cgpa.textContent = `CGPA: ${education.cgpa}`;

        // Append elements to education item
        educationItem.appendChild(title);
        educationItem.appendChild(university);
        educationItem.appendChild(graduationDate);
        educationItem.appendChild(cgpa);

        // Append education item to education container
        educationContainer.appendChild(educationItem);
    });
}

// Call the function to populate education data when the page is loaded
document.addEventListener('DOMContentLoaded', populateEducationData);


