// calendar.js

function populateCalendar(bookedDates) {
    // Get the table element for the calendar
    var calendarTable = document.getElementById('calendar');

    // Get today's date
    var today = new Date();

    // Get the current month and year
    var currentMonth = today.getMonth();
    var currentYear = today.getFullYear();

    // Calculate the first day of the month
    var firstDayOfMonth = new Date(currentYear, currentMonth, 1);

    // Calculate the number of days in the month
    var daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();

    // Create a header row for the calendar
    var headerRow = calendarTable.insertRow();
    var daysOfWeek = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    for (var i = 0; i < 7; i++) {
        var cell = headerRow.insertCell();
        cell.innerHTML = daysOfWeek[i];
    }

    // If bookedDates is null or undefined, default to an empty array
    //bookedDates = bookedDates || [];

    // Create a row for each week in the month
    var row;
    for (var i = 0; i < daysInMonth; i++) {
        // Start a new row at the beginning of each week
        if (i % 7 === 0) {
            row = calendarTable.insertRow();
        }

        // Create a cell for each day in the month
        var cell = row.insertCell();
        var currentDate = new Date(currentYear, currentMonth, i + 1);
        cell.innerHTML = i + 1;

        // Mark booked dates as unavailable
        if (bookedDates.includes(currentDate.toISOString().slice(0, 10))) {
            cell.classList.add('unavailable');
        }

        // Add additional classes to style the calendar as needed
        // For example, you can add classes for today's date, past dates, etc.
        if (currentDate.toDateString() === today.toDateString()) {
            cell.classList.add('today');
        }
    }
}

// Call the populateCalendar function with the booked dates retrieved from the server-side
populateCalendar(bookedDates);
