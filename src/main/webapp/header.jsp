<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechNexus Multi-Navbar</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        'tech-purple': '#8B5CF6',
                        'tech-pink': '#EC4899',
                    }
                }
            }
        }
    </script>
</head>
<body class="bg-gradient-to-br from-purple-900 via-gray-900 to-black min-h-screen">
<!-- Navbar 1 -->
<nav class="bg-gray-800 text-white py-2">
    <div class="container mx-auto px-4">
        <div class="flex justify-between items-center h-12">
            <div class="text-2xl font-extrabold">
                    <span class="bg-clip-text text-transparent bg-gradient-to-r from-tech-purple to-tech-pink">
                        Tech<span class="text-blue-400">Nexus</span>
                    </span>
            </div>
            <div class="md:hidden">
                <button onclick="toggleMenu('menu1')" class="text-white focus:outline-none">
                    <i class="fas fa-bars"></i>
                </button>
            </div>
            <div id="menu1" class="hidden md:flex md:items-center md:space-x-6 absolute md:relative left-0 right-0 top-14 md:top-0 bg-gray-800 md:bg-transparent p-4 md:p-0">
                <div class="relative inline-block text-left w-full md:w-auto">
                    <button onclick="toggleDropdown(event, this)" class="hover:text-tech-purple w-full md:w-auto text-left py-2 md:py-0">
                        Category
                        <i class="fas fa-chevron-down ml-1 text-xs"></i>
                    </button>
                    <div class="hidden absolute left-0 md:right-0 w-full md:w-48 py-2 mt-2 bg-gray-800 rounded-md shadow-xl z-10">
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Mobile</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">TV</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Speaker</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Cooler</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">iPad</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Pixel</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Laptop</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">PC</a>
                    </div>
                </div>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Products</a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Login</a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Register</a>
            </div>
        </div>
    </div>
</nav>

<!-- Increased gap -->
<div class="h-1 bg-tech-purple"></div>

<!-- Navbar 2 -->
<nav class="bg-gray-800 text-white py-2">
    <div class="container mx-auto px-4">
        <div class="flex justify-between items-center h-12">
            <div class="text-2xl font-extrabold">
                    <span class="bg-clip-text text-transparent bg-gradient-to-r from-tech-purple to-tech-pink">
                        Tech<span class="text-blue-400">Nexus</span>
                    </span>
            </div>
            <div class="md:hidden">
                <button onclick="toggleMenu('menu2')" class="text-white focus:outline-none">
                    <i class="fas fa-bars"></i>
                </button>
            </div>
            <div id="menu2" class="hidden md:flex md:items-center md:space-x-6 absolute md:relative left-0 right-0 top-14 md:top-0 bg-gray-800 md:bg-transparent p-4 md:p-0">
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Products</a>
                <div class="relative inline-block text-left w-full md:w-auto">
                    <button onclick="toggleDropdown(event, this)" class="hover:text-tech-purple w-full md:w-auto text-left py-2 md:py-0">
                        Category
                        <i class="fas fa-chevron-down ml-1 text-xs"></i>
                    </button>
                    <div class="hidden absolute left-0 md:right-0 w-full md:w-48 py-2 mt-2 bg-gray-800 rounded-md shadow-xl z-10">
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Mobile</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">TV</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Speaker</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Cooler</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">iPad</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Pixel</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Laptop</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">PC</a>
                    </div>
                </div>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Stocks</a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Shipped</a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Orders</a>
                <div class="relative inline-block text-left w-full md:w-auto">
                    <button onclick="toggleDropdown(event, this)" class="hover:text-tech-purple w-full md:w-auto text-left py-2 md:py-0">
                        Update Items
                        <i class="fas fa-chevron-down ml-1 text-xs"></i>
                    </button>
                    <div class="hidden absolute left-0 md:right-0 w-full md:w-48 py-2 mt-2 bg-gray-800 rounded-md shadow-xl z-10">
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Add Product</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Remove Product</a>
                        <a href="#" class="block px-4 py-2 text-sm hover:bg-gray-700">Update Product</a>
                    </div>
                </div>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Logout</a>
            </div>
        </div>
    </div>
</nav>

<!-- Increased gap -->
<div class="h-1 bg-tech-purple"></div>

<!-- Navbar 3 -->
<nav class="bg-gray-800 text-white py-2">
    <div class="container mx-auto px-4">
        <div class="flex justify-between items-center h-12">
            <div class="text-2xl font-extrabold">
                    <span class="bg-clip-text text-transparent bg-gradient-to-r from-tech-purple to-tech-pink">
                        Tech<span class="text-blue-400">Nexus</span>
                    </span>
            </div>
            <div class="md:hidden">
                <button onclick="toggleMenu('menu3')" class="text-white focus:outline-none">
                    <i class="fas fa-bars"></i>
                </button>
            </div>
            <div id="menu3" class="hidden md:flex md:items-center md:space-x-6 absolute md:relative left-0 right-0 top-14 md:top-0 bg-gray-800 md:bg-transparent p-4 md:p-0">
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Products</a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple flex items-center">
                    <i class="fas fa-shopping-cart mr-1"></i>
                    Cart
                </a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Order</a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Profile</a>
                <a href="#" class="block py-2 md:py-0 hover:text-tech-purple">Logout</a>
            </div>
        </div>
    </div>
</nav>

<!-- Search Bar -->
<div class="container mx-auto mt-4 px-4">
    <div class="flex">
        <input type="text" placeholder="Search..." class="w-full p-2 rounded-l-md bg-gray-700 text-white border border-tech-purple focus:outline-none focus:ring-2 focus:ring-tech-pink">
        <button class="bg-tech-purple hover:bg-tech-pink text-white font-bold py-2 px-4 rounded-r-md transition duration-300">
            Search
        </button>
    </div>
</div>

<script>
    let openDropdown = null;
    let openMenu = null;

    function toggleDropdown(event, button) {
        event.stopPropagation();
        const dropdown = button.nextElementSibling;

        if (openDropdown && openDropdown !== dropdown) {
            openDropdown.classList.add('hidden');
        }

        dropdown.classList.toggle('hidden');
        openDropdown = dropdown.classList.contains('hidden') ? null : dropdown;
    }

    function toggleMenu(menuId) {
        const menu = document.getElementById(menuId);
        if (openMenu && openMenu !== menu) {
            openMenu.classList.add('hidden');
        }
        menu.classList.toggle('hidden');
        openMenu = menu.classList.contains('hidden') ? null : menu;
    }

    document.addEventListener('click', function(event) {
        if (openDropdown && !openDropdown.contains(event.target)) {
            openDropdown.classList.add('hidden');
            openDropdown = null;
        }
        if (openMenu && !openMenu.contains(event.target) && !event.target.closest('button')) {
            openMenu.classList.add('hidden');
            openMenu = null;
        }
    });
</script>
</body>
</html>