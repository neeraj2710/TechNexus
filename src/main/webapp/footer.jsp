<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TechNexus Footer Contact</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/lucide@latest"></script>
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        'tech-purple': '#8B5CF6',
                        'tech-pink': '#EC4899',
                    },
                    animation: {
                        'gradient': 'gradient 8s ease infinite',
                    },
                    keyframes: {
                        'gradient': {
                            '0%, 100%': {
                                'background-size': '200% 200%',
                                'background-position': 'left center'
                            },
                            '50%': {
                                'background-size': '200% 200%',
                                'background-position': 'right center'
                            }
                        }
                    }
                }
            }
        }
    </script>
</head>
<body class="bg-gradient-to-br from-purple-900 via-gray-900 to-black min-h-screen">


<footer class="w-full py-12 px-4 sm:px-6 lg:px-8 bg-gray-800 bg-opacity-70">
    <div class="max-w-7xl mx-auto">
        <h2 class="text-3xl sm:text-4xl font-bold text-center bg-clip-text text-transparent bg-gradient-to-r from-tech-purple to-tech-pink animate-gradient mb-4">Contact</h2>
        <p class="text-center text-gray-300 mb-8">Thank You for Stopping By! TechNexus Mein Phir Milenge!</p>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
            <div class="space-y-4">
                <div class="flex items-center space-x-3 text-gray-300">
                    <i data-lucide="phone" class="w-5 h-5 text-tech-purple"></i>
                    <span>Phone : +91 7805055283</span>
                </div>
                <div class="flex items-center space-x-3 text-gray-300">
                    <i data-lucide="mail" class="w-5 h-5 text-tech-purple"></i>
                    <span>Email : neerajwadhwaney2003@gmail.com</span>
                </div>
                <div class="flex items-center space-x-3 text-gray-300">
                    <i data-lucide="map-pin" class="w-5 h-5 text-tech-purple"></i>
                    <span>Postal Code : 462021</span>
                </div>
            </div>

            <div class="md:col-span-2">
                <form action="#" class="space-y-4">
                    <div class="grid grid-cols-1 sm:grid-cols-2 gap-4">
                        <input type="text" placeholder="Name" required class="w-full px-4 py-2 bg-gray-700 bg-opacity-50 text-white rounded-lg focus:outline-none focus:ring-2 focus:ring-tech-pink focus:ring-opacity-50">
                        <input type="email" placeholder="Email" required class="w-full px-4 py-2 bg-gray-700 bg-opacity-50 text-white rounded-lg focus:outline-none focus:ring-2 focus:ring-tech-pink focus:ring-opacity-50">
                    </div>
                    <textarea rows="5" placeholder="Enter your message..." class="w-full px-4 py-2 bg-gray-700 bg-opacity-50 text-white rounded-lg focus:outline-none focus:ring-2 focus:ring-tech-pink focus:ring-opacity-50"></textarea>
                    <div>
                        <button type="button" class="px-6 py-2 bg-gradient-to-r from-yellow-400 to-yellow-600 text-white rounded-lg hover:from-yellow-500 hover:to-yellow-700 focus:outline-none focus:ring-2 focus:ring-yellow-500 focus:ring-opacity-50 transition duration-300 ease-in-out transform hover:scale-105">
                            Send
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</footer>

<script>
    lucide.createIcons();
</script>
</body>
</html>

