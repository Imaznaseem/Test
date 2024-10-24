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
            fetch('http://localhost:8080/api/cariogram/analyze', {
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
                if (cariogramChart) {
                    // Update existing chart
                    cariogramChart.data.datasets[0].data = data;
                    cariogramChart.update();
                } else {
                    // Create new chart
                    generatePieChart(data);
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
                labels: ['Caries', 'Diseases', 'Diet Contents', 'Diet Frequency', 'Plaque', 'Mutans', 'Fluoride', 'Saliva', 'Buffer', 'Judgement'],
                datasets: [{
                    data: data,
                    backgroundColor: ['#4CAF50', '#FFC107', '#00BCD4', '#F44336', '#2196F3', '#9C27B0', '#3F51B5', '#FF5722', '#607D8B', '#8BC34A']
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
                        color: '#fff',
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
});






