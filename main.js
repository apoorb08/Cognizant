// main.js

// 1. JavaScript Setup
console.log("Welcome to the Community Portal");
window.onload = () => {
  alert("Page fully loaded!");
};

// 2. Event Data Example
const eventName = "Community Yoga";
const eventDate = "2025-06-10";
let availableSeats = 25;
const eventInfo = `${eventName} on ${eventDate} - Seats left: ${availableSeats}`;
console.log(eventInfo);

function decrementSeats() {
  if (availableSeats > 0) {
    availableSeats--;
    console.log(`Seats remaining: ${availableSeats}`);
  } else {
    console.warn("No more seats available.");
  }
}

// 3. Conditionals and Error Handling
const events = [
  { name: "Music Night", date: "2025-07-01", seats: 10 },
  { name: "Book Fair", date: "2024-05-01", seats: 0 },
  { name: "Yoga Camp", date: "2025-08-15", seats: 20 }
];

function displayUpcomingEvents(eventList) {
  const today = new Date();
  eventList.forEach(e => {
    const eventDate = new Date(e.date);
    if (eventDate > today && e.seats > 0) {
      console.log(`Upcoming: ${e.name} on ${e.date}, Seats: ${e.seats}`);
    }
  });
}

displayUpcomingEvents(events);

// 4. Functions & Closures
function createRegistrationCounter() {
  let count = 0;
  return function () {
    count++;
    console.log(`Total Registrations: ${count}`);
  };
}
const registerMusic = createRegistrationCounter();

function addEvent(name, date, category) {
  events.push({ name, date, category, seats: 30 });
}

function filterEventsByCategory(category) {
  return events.filter(e => e.category === category);
}

// 5. Objects and Prototypes
function Event(name, date, seats) {
  this.name = name;
  this.date = date;
  this.seats = seats;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

const yogaEvent = new Event("Morning Yoga", "2025-06-15", 15);
console.log(Object.entries(yogaEvent));

// 6. Arrays & Methods
const musicEvents = events.filter(e => e.name.toLowerCase().includes("music"));
const eventCards = events.map(e => `${e.name} - ${e.date}`);

// 7. DOM Manipulation
function renderEvents() {
  const section = document.querySelector("#events");
  events.forEach(e => {
    const div = document.createElement("div");
    div.textContent = `${e.name} - ${e.date}`;
    section.appendChild(div);
  });
}

// 8. Event Handling
const registerBtn = document.querySelector("button[type='submit']");
if (registerBtn) {
  registerBtn.onclick = () => alert("Register button clicked");
}

// 9. Async/Await Example
async function fetchEvents() {
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await res.json();
    console.log("Fetched events:", data);
  } catch (err) {
    console.error("Failed to fetch events:", err);
  }
}

// 11. Working with Forms
function handleFormSubmit(event) {
  event.preventDefault();
  const form = event.target;
  const name = form.elements.name.value;
  const email = form.elements.email.value;
  if (!name || !email) {
    alert("Please fill in all required fields.");
    return;
  }
  console.log(`Registered: ${name} (${email})`);
}

// 12. AJAX Simulation
function postRegistration(data) {
  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((resData) => alert("Registration submitted successfully!"))
      .catch((err) => alert("Registration failed."));
  }, 1000);
}

// 14. jQuery Example
$(document).ready(function () {
  $("#registerBtn").click(function () {
    $("#register").fadeIn();
  });
});
