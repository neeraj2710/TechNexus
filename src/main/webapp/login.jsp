<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechNexus Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        .page-background {
            background: linear-gradient(to bottom right, #4a1d96, #111827, #000000);
            min-height: 100vh;
        }
        .card-custom {
            background-color: #1f2937;
            border-radius: 1rem;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.25);
            transition: all 0.3s;
        }
        .card-custom:hover {
            transform: scale(1.05);
        }
        .gradient-text {
            background: linear-gradient(to right, #c084fc, #ec4899, #ef4444);
            -webkit-background-clip: text;
            background-clip: text;
            color: transparent;
        }
        .blue-text {
            color: #60a5fa;
        }
        .form-control-custom {
            background-color: #374151;
            border: 1px solid #4b5563;
            color: white;
        }
        .form-control-custom:focus {
            background-color: #374151;
            border-color: #8b5cf6;
            box-shadow: 0 0 0 0.25rem rgba(139, 92, 246, 0.25);
            color: white;
        }
        .btn-custom {
            background: linear-gradient(to right, #9333ea, #db2777);
            transition: all 0.3s;
        }
        .btn-custom:hover {
            background: linear-gradient(to right, #7e22ce, #be185d);
            transform: scale(1.05);
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1);
        }
        .dot {
            width: 0.75rem;
            height: 0.75rem;
            border-radius: 50%;
            display: inline-block;
        }
        .dot-1 {
            background-color: #8b5cf6;
            animation: bounce 1s infinite;
        }
        .dot-2 {
            background-color: #ec4899;
            animation: bounce 1s infinite;
            animation-delay: 0.2s;
        }
        .dot-3 {
            background-color: #3b82f6;
            animation: bounce 1s infinite;
            animation-delay: 0.4s;
        }
        @keyframes bounce {
            0%, 100% {
                transform: translateY(0);
            }
            50% {
                transform: translateY(-10px);
            }
        }
        @keyframes pulse {
            0%, 100% {
                opacity: 1;
            }
            50% {
                opacity: 0.5;
            }
        }
        .animate-pulse {
            animation: pulse 2s cubic-bezier(0.4, 0, 0.6, 1) infinite;
        }
        @media (max-width: 576px) {
            .dot {
                width: 0.5rem;
                height: 0.5rem;
            }
        }
    </style>
    <!-- Bootstrap JS Bundle with Popper - Load BEFORE the include -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<div class="page-background">
    <!-- Include the header -->
    <jsp:include page="header.jsp"/>

    <!-- Login Form -->
    <div class="container d-flex align-items-center justify-content-center py-4">
        <div class="card-custom p-4 p-sm-5 w-100" style="max-width: 28rem;">
            <div class="text-center mb-4">
                <h2 class="display-5 fw-bold mb-2 gradient-text animate-pulse">
                    Tech<span class="blue-text">Nexus</span>
                </h2>
                <p class="text-secondary small">Connecting Innovation</p>
                <div class="mt-3 d-flex justify-content-center">
                    <span class="dot dot-1 mx-1"></span>
                    <span class="dot dot-2 mx-1"></span>
                    <span class="dot dot-3 mx-1"></span>
                </div>
            </div>
            <form>
                <div class="mb-3">
                    <label for="username" class="form-label text-light small fw-medium">Username</label>
                    <input
                            type="text"
                            id="username"
                            name="username"
                            required
                            class="form-control form-control-custom"
                    >
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label text-light small fw-medium">Password</label>
                    <input
                            type="password"
                            id="password"
                            name="password"
                            required
                            class="form-control form-control-custom"
                    >
                </div>
                <div class="mb-4">
                    <label for="userType" class="form-label text-light small fw-medium">User Type</label>
                    <select
                            id="userType"
                            name="userType"
                            class="form-select form-control-custom"
                    >
                        <option value="customer">Customer</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>
                <button
                        type="submit"
                        class="btn btn-custom text-white fw-bold py-3 w-100 rounded-3"
                >
                    Log In
                </button>
            </form>
        </div>
    </div>
</div>

<script>
    // Force reinitialize Bootstrap components after page load
    document.addEventListener('DOMContentLoaded', function() {
        // Wait a bit to ensure everything is loaded
        setTimeout(function() {
            // Manually initialize all dropdowns
            var dropdownElementList = document.querySelectorAll('.dropdown-toggle');
            dropdownElementList.forEach(function(dropdownToggleEl) {
                var dropdown = new bootstrap.Dropdown(dropdownToggleEl);
            });

            // Manually initialize all collapse elements (for mobile menu)
            var collapseElementList = document.querySelectorAll('.navbar-toggler');
            collapseElementList.forEach(function(collapseToggleEl) {
                collapseToggleEl.addEventListener('click', function() {
                    var targetId = this.getAttribute('data-bs-target');
                    var targetElement = document.querySelector(targetId);
                    var bsCollapse = new bootstrap.Collapse(targetElement);
                });
            });
        }, 500);
    });
</script>
</body>
</html>