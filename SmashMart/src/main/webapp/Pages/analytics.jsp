<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Analytics - SmashMart</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/analytics.css">
        <!-- Chart -->
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    </head>
    <body>

        <!-- NAVBAR -->
        <header class="navbar">
            <div class="container navbar-inner" style="display:flex; justify-content: space-between; align-items: center;">
                <span class="logo-text">Smash<span>Mart</span></span>

                <a href="${pageContext.request.contextPath}/adminDashboard" class="nav-btn">
                    Back
                </a>
            </div>
        </header>

        <!--  MAIN -->
        <main class="container">
            <h1>Analytics Overview</h1>

            <!--  SUMMARY CARDS -->
            <div class="summary-grid">
                <div class="summary-card">
                    <h3>Weekly Sales</h3>
                    <p>$${weeklySales}</p>
                </div>
                <div class="summary-card">
                    <h3>Monthly Sales</h3>
                    <p>$${monthlySales}</p>
                </div>
                <div class="summary-card">
                    <h3>Yearly Sales</h3>
                    <p>$${yearlySales}</p>
                </div>
                <div class="summary-card">
                    <h3>Total Revenue</h3>
                    <p>$${totalRevenue}</p>
                </div>
            </div>

            <!-- CHARTS -->
            <div class="chart-grid">
                <div class="card">
                    <h3>Revenue Chart</h3>
                    <canvas id="revenueChart"></canvas>
                </div>
                <div class="card">
                    <h3>Platform Growth</h3>
                    <canvas id="growthChart"></canvas>
                </div>
                <div class="card full">
                    <h3>Weekly Sales Trend</h3>
                    <canvas id="weeklyChart"></canvas>
                </div>
            </div>
        </main>

        <!--  FOOTER -->
        <footer class="site-footer">
            <p>&copy; 2026 SmashMart</p>
        </footer>

        <!--  CHART SCRIPT -->
        <script>
            // Revenue Chart
            new Chart(document.getElementById('revenueChart'), {
                type: 'bar',
                data: {
                    labels: ['Week', 'Month', 'Year'],
                    datasets: [{
                            label: 'Revenue',
                            data: [${weeklySales}, ${monthlySales}, ${yearlySales}],
                            backgroundColor: ['#3b82f6', '#10b981', '#f59e0b']
                        }]
                }
            });

            //  Growth Chart
            new Chart(document.getElementById('growthChart'), {
                type: 'line',
                data: {
                    labels: ['Users', 'Products', 'Orders'],
                    datasets: [{
                            label: 'Counts',
                            data: [${totalUsers}, ${totalProducts}, ${totalOrders}],
                            borderColor: '#2563eb',
                            fill: false,
                            tension: 0.3
                        }]
                }
            });

            //  Weekly Sales Trend
            new Chart(document.getElementById('weeklyChart'), {
                type: 'line',
                data: {
                    labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                    datasets: [{
                            label: 'Daily Sales',
                            data: [
            <c:forEach var="val" items="${weeklyTrend}" varStatus="loop">
                ${val}<c:if test="${!loop.last}">,</c:if>
            </c:forEach>
                            ],
                            borderColor: '#10b981',
                                    fill: false
                        }]
                }
            });

        </script>
    </body>
</html>