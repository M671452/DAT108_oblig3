class DeltagerManager {
    constructor(root) {
        this.root = root;
        this.deltagere = [];
        this.init();
    }

    init() {
        // Set up event listeners
        this.root.querySelector("button").addEventListener("click", () => this.registrerDeltager());
        document.getElementById("visDeltagere").addEventListener("click", () => this.visDeltagere());
    }

    async registrerDeltager() {
        const startnummer = document.getElementById('startnummer').value;
        const navn = document.getElementById('deltagernavn').value;
        const sluttid = document.getElementById('sluttid').value;

        const deltager = { startnummer, navn, sluttid };

        const response = await fetch('/api/deltagere/registrer', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(deltager)
        });

        if (response.ok) {
            const result = await response.json();
            // Use backticks for template literals
            alert(`Deltager ${result.navn} registrert med startnummer ${result.startnummer}`);
        } else {
            // Handle the error case
            alert("Det oppstod en feil ved registrering av deltager.");
        }
    }

    async visDeltagere() {
        const fra = document.getElementById('nedregrense').value;
        const til = document.getElementById('ovregrense').value;

        const response = await fetch(`/api/deltagere/vis?fra=${fra}&til=${til}`);
        const result = await response.json();

        const liste = document.querySelector("tbody");
        liste.innerHTML = ""; // Clear previous results

        result.forEach((deltager, index) => {
            const row = `<tr>
                <td>${index + 1}</td>
                <td>${deltager.startnummer}</td>
                <td>${deltager.navn}</td>
                <td>${deltager.sluttid}</td>
            </tr>`;
            liste.innerHTML += row;
        });
    }
}

// Initialize the DeltagerManager with the root element
const root = document.getElementById("root");
new DeltagerManager(root);
    