document.addEventListener('DOMContentLoaded', function() {
    const inputFields = [
        document.getElementById('caries'),
        document.getElementById('diseases'),
        document.getElementById('diet'),
        document.getElementById('diet-frequency'),
        document.getElementById('plaque'),
        document.getElementById('mutans'),
        document.getElementById('fluoride'),
        document.getElementById('saliva'),
        document.getElementById('buffer'),
        document.getElementById('judgement')
    ];

    let cariogramChart = null;

    // Save button
    document.getElementById('save').addEventListener('click', function() {
        const element = document.body; // You can specify another element to save if needed
        html2pdf()
            .set({ filename: 'cariogram.pdf' })
            .from(element)
            .save();
    });

    // Print button
    document.getElementById('print').addEventListener('click', function() {
        window.print();
    });

    inputFields.forEach(input => {
        input.addEventListener('input', updateChartIfNeeded);
    });

    function updateChartIfNeeded() {
            const values = inputFields.map(input => parseInt(input.value) || 0);
            const validValues = values.filter(value => value > 0);

            if (validValues.length >= 7) {
                fetch('/api/cariogram/analyze', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        inputValues: values.map(String) // Convert numbers to strings
                    })
                })
                .then(response => response.json())
                .then(data => {
                       const roundData = data.map(value => Math.round(value))

                    if (cariogramChart) {
                        // Update existing chart
                        cariogramChart.data.datasets[0].data = roundData;
                        cariogramChart.update();
                    } else {
                        // Create new chart
                        generatePieChart(roundData);
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Failed to generate the Cariogram. Please try again.');
                });
            }
        }

    function generatePieChart(data) {
        const ctx = document.getElementById('cariogramChart').getContext('2d');
        cariogramChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: ['Chance to Avoid Cavities', 'Diet', 'Bacteria', 'Susceptibility', 'Circumstances'],
                datasets: [{
                    data: data,
                    backgroundColor: ['#4CAF50', '#0000FF', '#FF0000', '#00FFFF', '#FFFF00']
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    tooltip: {
                        callbacks: {
                            label: function(tooltipItem) {
                                let total = tooltipItem.dataset.data.reduce((sum, val) => sum + val, 0);
                                let percentage = (tooltipItem.raw / total * 100).toFixed(2);
                                return `${tooltipItem.label}: ${percentage}%`;
                            }
                        }
                    },
                    legend: {
                        display: true,
                        position: 'bottom'
                    },
                    datalabels: {
                        color: function(context) {
                                                let backgroundColor = context.dataset.backgroundColor[context.dataIndex];
                                                return getContrastColor(backgroundColor);
                                            },
                        formatter: (value, ctx) => {
                            let sum = ctx.chart.data.datasets[0].data.reduce((sum, val) => sum + val, 0);
                            let percentage = (value / sum * 100).toFixed(2) + '%';
                            return percentage;
                        }
                    }
                }
            },
            plugins: [ChartDataLabels]
        });
    }


    // Helper function to get a contrasting color
    function getContrastColor(hexColor) {
        // Convert hex to RGB
        const rgb = hexColor.replace('#', '').match(/.{1,2}/g).map(x => parseInt(x, 16));
        // Calculate brightness
        const brightness = (0.299 * rgb[0] + 0.587 * rgb[1] + 0.114 * rgb[2]) / 255;
        // Return white for dark backgrounds and black for light backgrounds
        return brightness > 0.5 ? '#000000' : '#FFFFFF';
    }
});






