# Website Documentation for Cloverville

## Analysis

### Functional Requirements

The website for Cloverville should provide web access to villagers and visitors. The website needs to have:

1. **Display village information**: The website must display the description of Cloverville from an external JSON file (`VillageDescription.json`).

2. **Show green activities catalogue**: The website needs to display a catalogue of green activities from an external JSON file (`greenActivityList.json`), showing only activities from the last 7 days and filtering out duplicates.

3. **Display green points**: The website must display the total community green points from an external JSON file (`greenPoints.json`).

4. **Show green goals**: The website needs to display both the current active goal from `SavedGreenGoalList.json` and additional available goals from `greenGoalList.json`.

5. **Display available trades**: The website must display all available trade offers from an external JSON file (`tradesList.json`), showing trade names, points required, seller information, and descriptions.

6. **Provide navigation**: The website must provide consistent navigation across all pages with links to Backstory, Catalogue, Green points, Trades, and About us pages.

### Non-Functional Requirements

1. **Data format**: JSON format needs to be used for all data.

2. **Responsive design**: The website needs to be responsive.

3. **Color theme**: The website should use a green color palette to reflect the eco-friendly theme of CloverVille.

4. **User experience**: The website should have a clean interface with easy navigation.

### Use Case Diagram

The website use cases should be included in the overall use case diagram for the Cloverville system. The website-specific use cases include:

- **View Village Information**: Villager/Visitor views the backstory and description of Cloverville
- **Browse Green Activities**: Villager/Visitor browses the catalogue of recent green activities
- **View Green Points**: Villager/Visitor views the total community green points
- **View Green Goals**: Villager/Visitor views current and available green goals
- **Browse Trades**: Villager/Visitor browses available trade offers

### Use Case Descriptions and Activity Diagrams

Use case descriptions and activity diagrams for the website should be included in the Appendix of the SEP1 report.

## Design

### Website

#### Purpose and Description

The website for Cloverville serves as a web access portal for villagers and visitors to the eco-friendly village community. On this website, users can find information about Cloverville's backstory and philosophy, browse a catalogue of recent green activities that villagers have performed, view the total community green points accumulated, see current and available green goals that the community is working towards, and browse available trades where villagers exchange goods and services using green points. The website displays data imported from JSON files that are synchronized with the Java application, providing a public-facing view of the village's sustainability efforts and community engagement.

#### Layout Discussion

**Desktop Layout:**

The desktop layout was designed with simplicity and clarity in mind. The navigation bar is positioned at the top with the "Cloverville" brand name on the left and navigation links centered. The main content areas use CSS Grid and Flexbox for flexible, responsive layouts that adapt to different screen sizes while maintaining visual balance.

The homepage features a hero section with a large quote and call-to-action buttons, followed by a description section with alternating text and image layouts. The philosophy cards are displayed in a flexible grid that wraps naturally based on available space.

For pages with dynamic content (Catalogue, Green Points, Trades), the layout uses centered containers with appropriate spacing. The Green Points page features a prominent circular display for the total points, followed by goal cards arranged in a responsive grid.

The color palette was chosen using nature-inspired greens and beige tones:
- Primary green: `#235d2a` (dark green for borders and accents)
- Background: `beige` (warm, natural background)
- Text: `#1f2a1b` (dark green-gray for readability)
- Accent green: `#4e7f4f` (medium green for highlights)
- Light green: `#e1f1dd` (hover states)

The font type chosen for the website is **Inter** for body text and UI elements, providing excellent readability and a modern, clean appearance. The **Saira Stencil One** font is used for large headings on the Catalogue page to create visual impact.

**Mobile Layout:**

The mobile layout rearranges elements using CSS Grid's `auto-fit` and `minmax()` functions, which automatically stack elements vertically on smaller screens. Navigation links wrap naturally, and content sections stack in a single column. Some decorative elements (like the leaf images) are repositioned or scaled down to maintain visual balance without overwhelming the smaller screen.

The responsive design uses `clamp()` functions for font sizes and viewport-relative units (vw, vh) for spacing, ensuring that text and elements scale appropriately across different device sizes. Media queries were considered but the flexible grid approach provides sufficient responsiveness without explicit breakpoints.

**Wireframes:**

*Note: Wireframes should be included here showing the layout of both desktop and mobile versions of the main pages (index.html homepage and mobile version).*

Figure 1: Wireframe of desktop homepage layout showing navigation bar, hero section with quote and buttons, description section, and philosophy cards.

Figure 2: Wireframe of mobile homepage layout showing stacked navigation, full-width hero section, and vertically stacked content sections.

## Implementation

### Website

#### Content and Presentation Layers

**Navigation Bar Implementation:**

The navigation bar is implemented using a semantic HTML `<div>` element with the class `topnav`. The HTML structure includes a brand span element for "Cloverville" and anchor tags for each navigation link.

```html
<div class="topnav" id="myTopnav">
    <span class="Village">Cloverville</span>
    <a href="index.html">Backstory</a>
    <a href="catalogue.html">Catalogue</a>
    <a href="green-goal.html" class="active">Green points</a>
    <a href="trades.html">Trades</a>
    <a href="about-us.html">About us</a> 
</div>
```

The navigation bar is styled using Flexbox in CSS. On line 4-9 in `index-style.css`, the `.topnav` class uses `display: flex` with `justify-content: center` to center the navigation links, while `gap: 12px` provides consistent spacing between links. The brand name "Cloverville" is positioned absolutely on the left using `position: absolute` and `left: 22px` (lines 36-44), ensuring it doesn't interfere with the centered navigation links. The `padding: 4px 2px 4px 110px` provides extra left padding to prevent overlap with the brand name.

The navigation links are styled with rounded corners (`border-radius: 8px`), padding for clickable areas, and a smooth transition effect. On hover (lines 27-30), the background changes to a light green (`#e1f1dd`) and the text color darkens, providing clear visual feedback.

**Hero Section Implementation:**

The homepage hero section uses a CSS Grid layout to create a responsive two-column design that stacks on smaller screens.

```html
<div id="Quote">
  <div class="hero__text">
    <p class="SmallQuotes">Welcome to Green Bob's town</p>
    <p class="BigQuote">Grow together, earn green points, and light up Cloverville.</p>
    <p id="MediumQuote">Track the invisible green work, celebrate shared wins, and unlock rewards that make our eco-town thrive.</p>
    <div class="hero__actions">
      <a class="button primary" href="catalogue.html">Catalogue of Ideas</a>
      <a class="button ghost" href="green-goal.html">See Green Points</a>
    </div>
  </div>
  <img src="assets/image2.jpg" alt="">
</div>
```

The `#Quote` container (lines 83-89 in `index-style.css`) uses `display: grid` with `grid-template-columns: repeat(auto-fit, minmax(280px, 1fr))`, which creates a flexible grid that automatically adjusts the number of columns based on available space. The `gap: 28px` provides spacing between the text and image. The `align-items: center` property vertically centers the content.

The typography uses a responsive font size system: `.SmallQuotes` uses `font-size: 0.8rem` with uppercase transformation, `.BigQuote` uses `clamp(1.9rem, 3vw, 2.5rem)` which scales between 1.9rem and 2.5rem based on viewport width, ensuring readability across all screen sizes.

The call-to-action buttons use two variants: `.button.primary` has a green gradient background (`linear-gradient(135deg, #3c8c3e, #58ae55)`), while `.button.ghost` has a light background. Both buttons include a `transform: translateY(-1px)` on hover, creating a subtle lift effect that enhances interactivity.

**Green Points Display Implementation:**

The Green Points page features a prominent circular display for the total points.

```html
<div class="points-header">
    <h1>Community Green Points</h1>
    <h2 class="total-points">Total Points</h2>
    <div class="points-circle">
        <span class="points-number" id="totalPoints"></span>
    </div>
</div>
```

The `.points-circle` class (lines 129-139 in `web-style.css`) creates a circular container using `border-radius: 50%` with a fixed aspect ratio maintained by setting both `width: 25vw` and `height: 25vh`. The circle uses a dark green background (`#5b6e50`) and includes a box shadow for depth. The points number inside uses `clamp(2vmin, 4vw, 6vmax)` for responsive font sizing that scales with the viewport.

**Goal Cards Implementation:**

The goal cards are displayed in a responsive grid layout.

```html
<div class="goals-container" id="goalsContainer">
    <!-- JS will insert goal boxes here -->
</div>
```

The `.goals-container` (lines 177-184 in `web-style.css`) uses CSS Grid with `grid-template-columns: repeat(auto-fit, minmax(30vh, 1fr))`, creating a flexible grid that automatically adjusts the number of columns. Each `.goal-box` has a border, border-radius for rounded corners, padding for content spacing, and a box shadow for visual depth.

**Catalogue Page Video Background:**

The Catalogue page features a full-screen video background with overlaid text.

```html
<div class="main">
    <video class="video" autoplay muted loop src="assets/CatalogueVideo.mp4"></video>
    <h1>Catalogue of Ideas</h1>
</div>
```

The `.main` container (lines 51-60 in `Catalogue.css`) uses `position: relative` and `height: 100vh` to create a full-viewport-height container. The video element is positioned absolutely with `position: absolute`, `top: 0`, `left: 0`, and `width: 100%`, `height: 100%`, covering the entire container. The `object-fit: cover` ensures the video covers the area without distortion. The heading is positioned absolutely with `z-index: 9998` to appear above the video, using the `Saira Stencil One` font for dramatic effect.

**About Us Page Grid Layout:**

The About Us page displays team members in a responsive grid.

```html
<div id="wediv">
    <div>
        <img src="assets/batorgabora.jpeg" alt="" class="image">
        <p>Bátor Gábora</p>
        <p class="role">Software Developer</p>
        <a class="email" href="mailto:363085@viauc.dk">363085@viauc.dk</a>
        <p class="description">Front-end tinkerer who loves clean UI and probably other things too.</p>
    </div>
    <!-- More team members... -->
</div>
```

The `#wediv` container (lines 72-79 in `About-us.css`) uses CSS Grid with `grid-template-columns: repeat(auto-fit, minmax(220px, 1fr))`, creating a flexible grid that automatically adjusts based on available space. Each team member card contains an image with `border-radius: 14px` and a `border: 2px solid #e6dcc3` for visual definition. The email links use a green color (`#2f7a2f`) and include an underline on hover for accessibility.

**Decorative Leaf Elements:**

Several pages include decorative leaf images positioned absolutely in the corners.

```html
<img src="assets/leaves.png" id="leaves" alt="" class="leaves">
<img src="assets/leaves2.png" id="leaves2" alt="" class="leaves">
```

The leaf images (lines 84-117 in `web-style.css`) are positioned absolutely using viewport-relative units. For example, `#leaves` uses `left: 1.4vw` and `top: 3vh` with `transform: rotate(130deg)` to create a rotated decorative element. The `width: clamp(90px, 18vw, 190px)` ensures the images scale appropriately while maintaining minimum and maximum sizes. The `z-index: 9999` ensures they appear above other content.

#### Behavior Layer

**Loading Green Activities with Date Filtering:**

The JavaScript code loads green activities from a JSON file and filters them to show only activities from the last 7 days, while preventing duplicate entries.

```javascript
fetch('json/greenActivityList.json')
    .then(response => response.json())
    .then(data => {
        const activityList = document.querySelector('.activity-list');
        const now = new Date();
        const sevenDaysAgo = new Date();
        sevenDaysAgo.setDate(now.getDate() - 7);

        data.forEach(activity => {
            const { day, month, year } = activity.date;
            const activityDate = new Date(year, month - 1, day);

            if (activityDate < sevenDaysAgo) return;

            let isDuplicate = false;
            const items = activityList.querySelectorAll('.activity-item');

            for (let i = 0; i < items.length; i++) {
                const item = items[i];
                const itemDay = parseInt(item.dataset.day);
                const itemMonth = parseInt(item.dataset.month);
                const itemYear = parseInt(item.dataset.year);

                if (itemDay === day && itemMonth === month && itemYear === year) {
                    if (item.dataset.name === activity.activityName) {
                        isDuplicate = true;
                        break;  
                    }
                }
            }

            if (isDuplicate) return;

            const p = document.createElement("p");
            p.textContent = activity.activityName;
            p.classList.add('activity-item');
            p.dataset.name = activity.activityName;
            p.dataset.day = day;
            p.dataset.month = month;
            p.dataset.year = year;

            activityList.appendChild(p);
        });
    })
    .catch(error => console.error('Error fetching JSON:', error));
```

In this JavaScript code snippet, the `fetch()` function is used to asynchronously load the `greenActivityList.json` file. The response is converted to JSON using `.json()`, which returns a Promise. Once the data is loaded, a `forEach` loop iterates through each activity object.

For each activity, the code extracts the date components (day, month, year) and creates a JavaScript `Date` object. The `sevenDaysAgo` variable is calculated by creating a new Date object and using `setDate()` to subtract 7 days from the current date. If an activity's date is older than 7 days, the function returns early using `return`, skipping that activity.

To prevent duplicates, the code queries all existing activity items using `querySelectorAll('.activity-item')` and compares each new activity's date and name with existing items using the `dataset` properties stored on each element. If a duplicate is found (same date and same activity name), the `isDuplicate` flag is set to `true` and the function returns early.

If the activity passes both the date filter and duplicate check, a new paragraph element is created using `document.createElement("p")`. The activity name is set as the text content, and the element is given the `activity-item` class. The date and name are stored in the element's `dataset` properties for future duplicate checking. Finally, the new element is appended to the `activityList` container using `appendChild()`.

**Loading and Displaying Trades:**

The trades are loaded asynchronously and displayed in a formatted list.

```javascript
const outputDiv = document.getElementById('output');
let trades = [];

async function loadTrades() {
    const res = await fetch('json/tradesList.json');
    trades = await res.json();

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
```

In this code, an `async function` named `loadTrades()` is declared. The `async` keyword allows the function to use `await` for asynchronous operations. The function uses `fetch()` to load the `tradesList.json` file, and `await` pauses execution until the fetch completes. The response is then converted to JSON using `await res.json()`.

The trades array is processed using the `.map()` method, which creates a new array of HTML strings. Each trade object (`t`) is transformed into an HTML string using template literals (backticks), which allow embedded expressions using `${}`. The trade name is wrapped in `<strong>` tags for emphasis, and the seller's first and last names are concatenated. The `.join('')` method combines all the HTML strings into a single string, which is then assigned to `outputDiv.innerHTML`, replacing any existing content.

**Loading Green Goals:**

The green goals are loaded and displayed in goal boxes.

```javascript
fetch('json/greenGoalList.json')
    .then(response => response.json())
    .then(data => {
        const goalsContainer = document.getElementById("goalsContainer");
        
        goalsContainer.innerHTML = data.map(goal => `
            <div class="goal-box">
                <h4>${goal.goalName}</h4>
                <p><strong>Required Points:</strong> ${goal.requiredPoints}</p>
                <p><strong>Description:</strong> ${goal.greenDescriptions}</p>
            </div>
        `).join('');
    })
    .catch(error => console.error('Error fetching JSON:', error));
```

This code uses the Promise-based `fetch()` API with `.then()` chaining. The first `.then()` converts the response to JSON, and the second `.then()` processes the data. The `goalsContainer` element is retrieved using `getElementById()`. The goals array is mapped to HTML strings, creating a `goal-box` div for each goal with the goal name, required points, and description. The `.join('')` method combines all HTML strings, and the result is assigned to `innerHTML` to render the goals on the page.

**Loading Saved Green Goal:**

The current active goal is loaded from a separate JSON file and displayed prominently.

```javascript
const savedGoalDiv = document.getElementById("savedGoal");
if (savedGoalDiv) {
    fetch('json/SavedGreenGoalList.json')
        .then(response => response.json())
        .then(data => {
            const goal = data[0];
            
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
```

This code first checks if the `savedGoalDiv` element exists using an `if` statement, preventing errors if the element is not present on the current page. The first element of the data array (`data[0]`) is extracted since `SavedGreenGoalList.json` contains only one goal object. The goal information is then formatted into HTML and inserted into the div.

**Loading Village Description:**

The village description is loaded and displayed on the homepage.

```javascript
fetch('json/VillageDescription.json')
    .then(response => response.json())
    .then(data => {
        const villageDescription = data[0];
        document.getElementById("DescriptionJson").innerHTML = villageDescription;
    })
    .catch(error => console.error('Error fetching JSON:', error));
```

This code loads the village description from JSON. Since `VillageDescription.json` is an array with a single string element, `data[0]` extracts that string, which is then inserted into the `DescriptionJson` element's innerHTML.

**Loading Total Green Points:**

The total community green points are loaded and displayed in the circular points display.

```javascript
fetch('json/greenPoints.json')
    .then(response => response.json())
    .then(data => {
        const TotalPoints = data[0];
        document.getElementById("totalPoints").innerHTML = TotalPoints;
    })
    .catch(error => console.error('Error fetching JSON:', error));
```

Similar to the village description, this code extracts the first element from the JSON array (which contains the total points as a number) and displays it in the `totalPoints` span element, which is nested inside the circular points display.

All fetch operations include `.catch()` error handlers that log errors to the console, providing debugging information if JSON files fail to load or are malformed.

## Test

### Website Functional Requirements Testing

The following test cases verify that the website's functional requirements are met:

| Use Case | Test Case | Result |
|----------|-----------|--------|
| Display village information | JSON file (VillageDescription.json) placed on webserver | The village description is imported correctly from the JSON file and displayed on the homepage in the DescriptionJson element. |
| Show green activities catalogue | JSON file (greenActivityList.json) placed on webserver | The green activities are imported correctly from the JSON file. Only activities from the last 7 days are displayed, duplicates are filtered out, and activities are shown on the Catalogue page. |
| Display green points | JSON file (greenPoints.json) placed on webserver | The total community green points are imported correctly from the JSON file and displayed in the circular points display on the Green Points page. |
| Show green goals | JSON files (SavedGreenGoalList.json and greenGoalList.json) placed on webserver | The current active goal is imported correctly from SavedGreenGoalList.json and displayed prominently. Additional available goals are imported correctly from greenGoalList.json and displayed as goal boxes in a grid layout on the Green Points page. |
| Display available trades | JSON file (tradesList.json) placed on webserver | All available trade offers are imported correctly from the JSON file and displayed on the Trades page. Each trade shows the trade name, points required, seller information (first name and last name), and description. |
| Provide navigation | User navigates between pages using navigation links | Consistent navigation is provided across all pages. Navigation links correctly route to Backstory (index.html), Catalogue (catalogue.html), Green points (green-goal.html), Trades (trades.html), and About us (about-us.html) pages. |

### Website Non-Functional Requirements Testing

The following test cases verify that the website's non-functional requirements are met:

| Use Case | Test Case | Result |
|----------|-----------|--------|
| Data format | All data files are in JSON format | All external data files (VillageDescription.json, greenActivityList.json, greenPoints.json, greenGoalList.json, SavedGreenGoalList.json, tradesList.json) are in JSON format and are successfully parsed and displayed by the website. |
| Responsive design | Website is viewed on different screen sizes (mobile, tablet, desktop) | The website adapts appropriately to different screen sizes. Layout elements stack vertically on mobile devices, navigation wraps appropriately, and content remains readable and accessible across all device sizes. |
| Color theme | Website pages are displayed | The website uses a green color palette throughout (including colors such as #235d2a, #4e7f4f, #e1f1dd, beige backgrounds) that reflects the eco-friendly theme of Cloverville. |
| User experience | User navigates and interacts with the website | The website provides a clean interface with easy navigation. Navigation links are clearly visible, content is well-organized, and the interface is intuitive for users to find information. |

### Test Results Summary

All functional and non-functional requirements for the website have been successfully tested and verified. The website correctly imports and displays data from all JSON files in the required format, provides consistent and functional navigation across all pages, adapts appropriately to different screen sizes with responsive design, uses a green color palette that reflects the eco-friendly theme, and provides a clean interface with easy navigation for users.

