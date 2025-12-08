fetch('json/greenActivityList.json')
    .then(response => response.json())
    .then(data => {
        const tbody = document.getElementById("tableBody");

        for (let i = 0; i < data.length; i++) {

            const activity = data[i];

            // Format nested date object
            const d = activity.date;
            const formattedDate = `${d.day}/${d.month}/${d.year}`;

            // Create table row
            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${activity.activityName}</td>
                <td>${activity.points}</td>
                <td>${formattedDate}</td>
            `;

            tbody.appendChild(row);
        }
    })
    .catch(error => console.error('Error fetching JSON:', error));


let trades = [];

async function loadTrades() {
  const res = await fetch('./json/tradesList.json');
  trades = await res.json();  // ← SAVED HERE
}

loadTrades();