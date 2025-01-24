<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechNexus Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<jsp:include page="header.jsp"/>
<body class="bg-gradient-to-br from-purple-900 via-gray-900 to-black min-h-screen flex items-center justify-center p-4">

<div class="bg-gray-800 p-6 sm:p-8 rounded-2xl shadow-2xl w-full max-w-md transform hover:scale-105 transition-all duration-300">
    <div class="text-center mb-8">
        <h2 class="text-4xl sm:text-5xl font-extrabold mb-2 text-transparent bg-clip-text bg-gradient-to-r from-purple-400 via-pink-500 to-red-500 animate-pulse">
            Tech<span class="text-blue-400">Nexus</span>
        </h2>
        <p class="text-gray-400 text-xs sm:text-sm">Connecting Innovation</p>
        <div class="mt-4 flex justify-center space-x-2">
            <span class="inline-block w-2 h-2 sm:w-3 sm:h-3 bg-purple-500 rounded-full animate-bounce"></span>
            <span class="inline-block w-2 h-2 sm:w-3 sm:h-3 bg-pink-500 rounded-full animate-bounce" style="animation-delay: 0.2s"></span>
            <span class="inline-block w-2 h-2 sm:w-3 sm:h-3 bg-blue-500 rounded-full animate-bounce" style="animation-delay: 0.4s"></span>
        </div>
    </div>
    <form>
        <div class="mb-4">
            <label for="username" class="block text-sm font-medium text-gray-300 mb-1">Username</label>
            <input
                    type="text"
                    id="username"
                    name="username"
                    required
                    class="w-full px-3 py-2 bg-gray-700 border border-gray-600 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-500 transition duration-200 text-white"
            >
        </div>
        <div class="mb-4">
            <label for="password" class="block text-sm font-medium text-gray-300 mb-1">Password</label>
            <input
                    type="password"
                    id="password"
                    name="password"
                    required
                    class="w-full px-3 py-2 bg-gray-700 border border-gray-600 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-500 transition duration-200 text-white"
            >
        </div>
        <div class="mb-6">
            <label for="userType" class="block text-sm font-medium text-gray-300 mb-1">User Type</label>
            <select
                    id="userType"
                    name="userType"
                    class="w-full px-3 py-2 bg-gray-700 border border-gray-600 rounded-md focus:outline-none focus:ring-2 focus:ring-purple-500 transition duration-200 text-white"
            >
                <option value="customer">Customer</option>
                <option value="admin">Admin</option>
            </select>
        </div>
        <button
                type="submit"
                class="w-full bg-gradient-to-r from-purple-600 to-pink-600 text-white font-bold py-3 px-4 rounded-md hover:from-purple-700 hover:to-pink-700 transition duration-300 transform hover:scale-105 hover:shadow-lg"
        >
            Log In
        </button>
    </form>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>