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


const gbody = document.getElementById("tableBody1");
if (gbody) {
    fetch('json/greenGoalList.json')
        .then(response => response.json())
        .then(data => {
            for (let i = 0; i < 3; i++) {
                const goal = data[i];
                
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${goal.goalName}</td>
                    <td>${goal.requiredPoints}</td>
                    <td>${goal.greenDescriptions}</td>
                `;
                gbody.appendChild(row);
            }
        })
        .catch(error => console.error('Error fetching JSON:', error));
}

// SAVED GREEN GOAL - Display on page (for SavedGreenGoalList.json)
const savedGoalDiv = document.getElementById("savedGoal");
if (savedGoalDiv) {
    fetch('json/SavedGreenGoalList.json')
        .then(response => response.json())
        .then(data => {
            const goal = data[0]; // Get the first (and only) item
            
            savedGoalDiv.innerHTML = `
                <div class="saved-goal-display">
                    <h3>Current Goal</h3>
                    <p><strong>Goal:</strong> ${goal.goalName}</p>
                    <p><strong>Required Points:</strong> ${goal.requiredPoints}</p>
                    <p><strong>Description:</strong> ${goal.greenDescriptions}</p>
                </div>
            `;
        })
        .catch(error => console.error('Error fetching saved goal:', error));
}


fetch('json/VillageDescription.json')
    .then(response => response.json())
    .then(data => {
        //const villageDescription = data.text; // Assuming 'text' is the key
        // Set the text content directly without table tags
       // document.getElementById("DescriptionJson").innerHTML = villageDescription; 
       const villageDescription = data[0];
        document.getElementById("DescriptionJson").innerHTML = villageDescription;
    })
    .catch(error => console.error('Error fetching JSON:', error));