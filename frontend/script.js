const API_URL = "https://affordable-meal-finder-zl8r.onrender.com/meals";

async function loadMeals() {

    try {

        const response = await fetch(API_URL);

        const meals = await response.json();

        displayMeals(meals);

    } catch (error) {

        console.error("Error loading meals:", error);

        document.getElementById("mealContainer").innerHTML =
            "<p>Unable to load meals. Make sure Spring Boot is running.</p>";
    }
}


function displayMeals(meals) {

    const container = document.getElementById("mealContainer");

    container.innerHTML = "";

    if (meals.length === 0) {

        container.innerHTML = "<p>No meals found 😭</p>";

        return;
    }

    meals.forEach(meal => {

        const card = document.createElement("div");

        card.className = "meal-card";

        card.innerHTML = `
            <h3>🍱 ${meal.name}</h3>
            <p>📂 ${meal.category}</p>
            <p>🏪 ${meal.restaurant}</p>
            <p>👤 ${meal.vendorType || "Vendor"}</p>
            <p class="price">₹${meal.price}</p>
        `;

        container.appendChild(card);

    });
}


function findMeals() {

    const search = document.getElementById("search").value.toLowerCase();
    const budget = document.getElementById("budget").value;
    const category = document.getElementById("category").value;
    const vendorType = document.getElementById("vendorType").value;

    fetch(API_URL)
        .then(response => response.json())
        .then(meals => {

            let filteredMeals = meals;

            if (search) {
                filteredMeals = filteredMeals.filter(meal =>
                    meal.name.toLowerCase().includes(search)
                );
            }

            if (budget) {
                filteredMeals = filteredMeals.filter(meal =>
                    meal.price <= Number(budget)
                );
            }

            if (category) {
                filteredMeals = filteredMeals.filter(meal =>
                    meal.category === category
                );
            }

            if (vendorType) {
                filteredMeals = filteredMeals.filter(meal =>
                    meal.vendorType === vendorType
                );
            }

            displayMeals(filteredMeals);

        });
}


loadMeals();