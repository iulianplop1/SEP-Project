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




const outputDiv = document.getElementById('output');
let trades = [];

async function loadTrades() {
    const res = await fetch('json/tradesList.json');
    trades = await res.json();  // JSON loaded

    outputDiv.innerHTML = trades
        .map(t => `
            <div>
                <strong>${t.tradename}</strong>  [${t.points}] by \t
                 ${t.seller.firstname} ${t.seller.lastname} - 
                 "${t.description}"
            </div>
        `)
        .join('');
}

loadTrades();

fetch('json/greenGoalList.json')
    .then(response => response.json())
    .then(data => {
        const tbody = document.getElementById("tableBody1");

        for (let i = 0; i < data.length; i++) {

            const goal = data[i];

            // Format nested date object
            const d = goal.description;

            // Create table row
            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${goal.goalName}</td>
                <td>${goal.RequiredPoints}</td>
                <td>${goal.description}</td>
            `;

            t.appendChild(row);
        }
    })
    .catch(error => console.error('Error fetching JSON:', error));
    

fetch('json/VillageDescription.json')
    .then(response => response.json())
    .then(data => {
        // Assuming your JSON is a single object with a key like 'text'
        const villageDescription = data.text; // Adjust based on actual JSON keys
        document.getElementById("DescriptionJson").innerHTML = `<tr><td>${villageDescription}</td></tr>`;
    })
    .catch(error => console.error('Error fetching JSON:', error));