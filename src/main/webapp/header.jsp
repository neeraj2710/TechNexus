<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechNexus Multi-Navbar</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        :root {
            --tech-purple: #8B5CF6;
            --tech-pink: #EC4899;
            --tech-blue: #60A5FA;
        }

        body {
            background: linear-gradient(to bottom right, #4a1d96, #111827, #000000);
            min-height: 100vh;
        }

        .navbar-custom {
            background-color: #1f2937;
        }

        .brand-text {
            background: linear-gradient(to right, var(--tech-purple), var(--tech-pink));
            -webkit-background-clip: text;
            background-clip: text;
            color: transparent;
        }

        .blue-text {
            color: var(--tech-blue);
        }

        .nav-link:hover, .dropdown-item:hover {
            color: var(--tech-purple) !important;
        }

        .dropdown-menu {
            background-color: #1f2937;
            border: 1px solid var(--tech-purple);
        }

        .dropdown-item {
            color: white;
        }

        .dropdown-item:hover, .dropdown-item:focus {
            background-color: #374151;
            color: var(--tech-purple);
        }

        .purple-divider {
            height: 2px;
            background-color: var(--tech-purple);
        }

        .search-input {
            background-color: #374151;
            color: white;
            border: 1px solid var(--tech-purple);
        }

        .search-input:focus {
            background-color: #374151;
            color: white;
            box-shadow: 0 0 0 0.25rem rgba(139, 92, 246, 0.25);
            border-color: var(--tech-pink);
        }

        .search-button {
            background-color: var(--tech-purple);
            color: white;
        }

        .search-button:hover {
            background-color: var(--tech-pink);
            color: white;
        }

        @media (max-width: 767.98px) {
            .navbar-collapse {
                background-color: #1f2937;
                padding: 1rem;
            }
        }
    </style>
</head>
<body>
<div class="container-fluid p-0">
    <!-- Navbar 1 -->
    <nav class="navbar navbar-expand-md navbar-dark navbar-custom py-2">
        <div class="container">
            <a class="navbar-brand" href="#">
                <span class="fs-4 fw-bold brand-text">Tech<span class="blue-text">Nexus</span></span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu1">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="menu1">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Category
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><a class="dropdown-item" href="#">Mobile</a></li>
                            <li><a class="dropdown-item" href="#">TV</a></li>
                            <li><a class="dropdown-item" href="#">Speaker</a></li>
                            <li><a class="dropdown-item" href="#">Cooler</a></li>
                            <li><a class="dropdown-item" href="#">iPad</a></li>
                            <li><a class="dropdown-item" href="#">Pixel</a></li>
                            <li><a class="dropdown-item" href="#">Laptop</a></li>
                            <li><a class="dropdown-item" href="#">PC</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Register</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Divider -->
    <div class="purple-divider"></div>

    <!-- Navbar 2 -->
    <nav class="navbar navbar-expand-md navbar-dark navbar-custom py-2">
        <div class="container">
            <a class="navbar-brand" href="#">
                <span class="fs-4 fw-bold brand-text">Tech<span class="blue-text">Nexus</span></span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu2">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="menu2">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Products</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Category
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><a class="dropdown-item" href="#">Mobile</a></li>
                            <li><a class="dropdown-item" href="#">TV</a></li>
                            <li><a class="dropdown-item" href="#">Speaker</a></li>
                            <li><a class="dropdown-item" href="#">Cooler</a></li>
                            <li><a class="dropdown-item" href="#">iPad</a></li>
                            <li><a class="dropdown-item" href="#">Pixel</a></li>
                            <li><a class="dropdown-item" href="#">Laptop</a></li>
                            <li><a class="dropdown-item" href="#">PC</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Stocks</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Shipped</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Orders</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Update Items
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><a class="dropdown-item" href="#">Add Product</a></li>
                            <li><a class="dropdown-item" href="#">Remove Product</a></li>
                            <li><a class="dropdown-item" href="#">Update Product</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Divider -->
    <div class="purple-divider"></div>

    <!-- Navbar 3 -->
    <nav class="navbar navbar-expand-md navbar-dark navbar-custom py-2">
        <div class="container">
            <a class="navbar-brand" href="#">
                <span class="fs-4 fw-bold brand-text">Tech<span class="blue-text">Nexus</span></span>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#menu3">
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="menu3">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fas fa-shopping-cart me-1"></i>Cart
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Order</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Search Bar -->
    <div class="container mt-4">
        <div class="row">
            <div class="col-12">
                <div class="input-group">
                    <input type="text" class="form-control search-input" placeholder="Search...">
                    <button class="btn search-button" type="button">Search</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>