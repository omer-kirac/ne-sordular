'use client';

import { useState, useEffect } from 'react';
import Link from 'next/link';
import { usePathname } from 'next/navigation';
import './globals.css';

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const [isProfileOpen, setIsProfileOpen] = useState(false);
  const [darkMode, setDarkMode] = useState(false);
  const pathname = usePathname();

  useEffect(() => {
    const isDark = localStorage.getItem('darkMode') === 'true';
    setDarkMode(isDark);
    if (isDark) {
      document.documentElement.classList.add('dark');
    }
  }, []);

  const toggleDarkMode = () => {
    const newDarkMode = !darkMode;
    setDarkMode(newDarkMode);
    localStorage.setItem('darkMode', String(newDarkMode));
    document.documentElement.classList.toggle('dark');
  };

  const navItems = [
    { href: '/sorular', label: 'Sorular' },
    { href: '/is-ilanlari', label: 'İş İlanları' },
    { href: '/sirketler', label: 'Şirketler' },
    { href: '/maaslar', label: 'Maaşlar' },
  ];

  return (
    <html lang="en" className={darkMode ? 'dark' : ''}>
      <body className="bg-white dark:bg-gray-900 transition-colors duration-200">
        <div>
          <header className="bg-white border-b shadow-sm dark:bg-gray-800 dark:border-gray-700">
            <div className="max-w-7xl mx-auto px-4 sm:px-6">
              <div className="flex justify-between items-center h-16">
                {/* Logo placeholder */}
                <Link href="/" className="w-40 h-8 bg-emerald-50 dark:bg-emerald-900/30 flex items-center justify-center rounded">
                  <span className="text-emerald-600 dark:text-emerald-400 font-semibold">LOGO</span>
                </Link>

                {/* Navigation */}
                <nav className="flex space-x-8">
                  {navItems.map((item) => (
                    <Link
                      key={item.href}
                      href={item.href}
                      className={`relative px-3 py-2 transition-colors ${
                        pathname === item.href
                          ? 'text-emerald-600 dark:text-emerald-400 font-medium'
                          : 'text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400'
                      }`}
                    >
                      {item.label}
                      {pathname === item.href && (
                        <div className="absolute bottom-0 left-0 right-0 h-0.5 bg-emerald-600 dark:bg-emerald-400" />
                      )}
                    </Link>
                  ))}
                </nav>

                {/* Right side buttons */}
                <div className="flex items-center space-x-4">
                  {/* Dark Mode Toggle Button */}
                  <button 
                    onClick={toggleDarkMode}
                    className="p-2 text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400"
                    aria-label="Toggle dark mode"
                  >
                    {!darkMode ? (
                      <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fillRule="evenodd" d="M10 2a1 1 0 011 1v1a1 1 0 11-2 0V3a1 1 0 011-1zm4 8a4 4 0 11-8 0 4 4 0 018 0zm-.464 4.95l.707.707a1 1 0 001.414-1.414l-.707-.707a1 1 0 00-1.414 1.414zm2.12-10.607a1 1 0 010 1.414l-.706.707a1 1 0 11-1.414-1.414l.707-.707a1 1 0 011.414 0zM17 11a1 1 0 100-2h-1a1 1 0 100 2h1zm-7 4a1 1 0 011 1v1a1 1 0 11-2 0v-1a1 1 0 011-1zM5.05 6.464A1 1 0 106.465 5.05l-.708-.707a1 1 0 00-1.414 1.414l.707.707zm1.414 8.486l-.707.707a1 1 0 01-1.414-1.414l.707-.707a1 1 0 011.414 1.414zM4 11a1 1 0 100-2H3a1 1 0 000 2h1z" clipRule="evenodd" />
                      </svg>
                    ) : (
                      <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path d="M17.293 13.293A8 8 0 016.707 2.707a8.001 8.001 0 1010.586 10.586z" />
                      </svg>
                    )}
                  </button>
                  
                  {/* Search Button */}
                  <button className="p-2 text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400">
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                      <path fillRule="evenodd" d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z" clipRule="evenodd" />
                    </svg>
                  </button>

                  {/* Notifications Button */}
                  <button className="p-2 text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400">
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                      <path d="M10 2a6 6 0 00-6 6v3.586l-.707.707A1 1 0 004 14h12a1 1 0 00.707-1.707L16 11.586V8a6 6 0 00-6-6zM10 18a3 3 0 01-3-3h6a3 3 0 01-3 3z" />
                    </svg>
                  </button>

                  {/* Profile Dropdown */}
                  <div className="relative">
                    <button 
                      className="p-2 text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400"
                      onClick={() => setIsProfileOpen(!isProfileOpen)}
                    >
                      <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                        <path fillRule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-6-3a2 2 0 11-4 0 2 2 0 014 0zm-2 4a5 5 0 00-4.546 2.916A5.986 5.986 0 0010 16a5.986 5.986 0 004.546-2.084A5 5 0 0010 11z" clipRule="evenodd" />
                      </svg>
                    </button>
                    
                    {isProfileOpen && (
                      <div className="absolute right-0 mt-2 w-48 bg-white dark:bg-gray-800 rounded-md shadow-lg py-1 z-10 border border-gray-100 dark:border-gray-700">
                        <Link href="/profile" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-50 hover:text-emerald-600 dark:text-gray-200 dark:hover:bg-gray-700/50 dark:hover:text-emerald-400">
                          Profile
                        </Link>
                        <Link href="/job-activity" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-50 hover:text-emerald-600 dark:text-gray-200 dark:hover:bg-gray-700/50 dark:hover:text-emerald-400">
                          Job Activity
                        </Link>
                        <Link href="/contributions" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-50 hover:text-emerald-600 dark:text-gray-200 dark:hover:bg-gray-700/50 dark:hover:text-emerald-400">
                          Contributions
                        </Link>
                        <Link href="/settings" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-50 hover:text-emerald-600 dark:text-gray-200 dark:hover:bg-gray-700/50 dark:hover:text-emerald-400">
                          Settings
                        </Link>
                        <Link href="/help" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-50 hover:text-emerald-600 dark:text-gray-200 dark:hover:bg-gray-700/50 dark:hover:text-emerald-400">
                          Help Center
                        </Link>
                        <div className="border-t border-gray-100 dark:border-gray-700"></div>
                        <Link href="/signout" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-50 hover:text-emerald-600 dark:text-gray-200 dark:hover:bg-gray-700/50 dark:hover:text-emerald-400">
                          Sign Out
                        </Link>
                      </div>
                    )}
                  </div>
                </div>
              </div>
            </div>
          </header>

          {children}
        </div>
      </body>
    </html>
  );
}
