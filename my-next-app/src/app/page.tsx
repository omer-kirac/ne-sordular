'use client';

import { useState } from 'react';

export default function Home() {
  const [postText, setPostText] = useState('');

  const dummyPosts = [
    {
      id: 1,
      category: 'Tech',
      role: 'Computer Technician',
      content: 'Anyone else or know of colleagues having issues with 2 Factor Authentication? I was finally able to get in through a social login token, but I\'m afraid of losing my account...',
      timeAgo: '1h',
      likes: 1,
      comments: 0,
    },
    {
      id: 2,
      category: 'Tech',
      role: 'Sales Associate/cashier',
      content: 'Has anyone heard of Barwon Health and their remote jobs? I applied there, was interviewed and hired, but still awaiting equipment. It\'s been a week since I was hired on.',
      timeAgo: '3h',
      likes: 1,
      comments: 5,
    }
  ];

  return (
    <main className="max-w-3xl mx-auto p-4 sm:p-6 lg:p-8">
      {/* Post Creation Area */}
      <div className="bg-white dark:bg-gray-800 rounded-lg shadow-sm border border-gray-100 dark:border-gray-700">
        <div className="p-4 border-b border-gray-100 dark:border-gray-700 flex items-center gap-3">
          <div className="w-10 h-10 bg-gray-50 dark:bg-gray-700 rounded-full flex items-center justify-center">
            <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6 text-gray-400 dark:text-gray-500" viewBox="0 0 20 20" fill="currentColor">
              <path fillRule="evenodd" d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-6-3a2 2 0 11-4 0 2 2 0 014 0zm-2 4a5 5 0 00-4.546 2.916A5.986 5.986 0 0010 16a5.986 5.986 0 004.546-2.084A5 5 0 0010 11z" clipRule="evenodd" />
            </svg>
          </div>
          <div className="flex-grow">
            <div className="text-sm font-medium text-gray-900 dark:text-white">Post anonymously as</div>
            <div className="text-sm text-gray-500 dark:text-gray-400">attends Yildiz teknik üniversitesi</div>
          </div>
        </div>
        <div className="p-4">
          <textarea
            className="w-full border border-gray-200 dark:border-gray-600 rounded-lg p-3 bg-white dark:bg-gray-700 text-gray-900 dark:text-white placeholder-gray-500 dark:placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-emerald-500 focus:border-transparent"
            placeholder="Post as 'attends Yildiz teknik üniversitesi'"
            rows={3}
            value={postText}
            onChange={(e) => setPostText(e.target.value)}
          />
          <div className="mt-3 flex justify-end">
            <button className="bg-emerald-600 hover:bg-emerald-700 dark:bg-emerald-500 dark:hover:bg-emerald-600 text-white px-4 py-2 rounded-full flex items-center gap-2 transition-colors">
              <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                <path fillRule="evenodd" d="M10 3a1 1 0 011 1v5h5a1 1 0 110 2h-5v5a1 1 0 11-2 0v-5H4a1 1 0 110-2h5V4a1 1 0 011-1z" clipRule="evenodd" />
              </svg>
              Create Post
            </button>
          </div>
        </div>
      </div>

      {/* Posts Feed */}
      <div className="space-y-6 mt-6">
        {dummyPosts.map(post => (
          <div key={post.id} className="bg-white dark:bg-gray-800 rounded-lg shadow-sm border border-gray-100 dark:border-gray-700">
            <div className="p-4">
              <div className="flex items-center justify-between mb-4">
                <div className="flex items-center gap-3">
                  <div className="flex-shrink-0">
                    <div className="w-12 h-12 bg-emerald-50 dark:bg-emerald-900/30 rounded-lg flex items-center justify-center">
                      <span className="text-emerald-600 dark:text-emerald-400 font-medium">{post.category}</span>
                    </div>
                  </div>
                  <div>
                    <div className="text-sm font-medium text-gray-900 dark:text-white">{post.category}</div>
                    <div className="text-sm text-gray-500 dark:text-gray-400">{post.role}</div>
                  </div>
                </div>
                <div className="flex items-center gap-2">
                  <span className="text-sm text-gray-500 dark:text-gray-400">{post.timeAgo}</span>
                  <button className="text-gray-400 hover:text-gray-500 dark:text-gray-500 dark:hover:text-gray-400">
                    <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                      <path d="M6 10a2 2 0 11-4 0 2 2 0 014 0zM12 10a2 2 0 11-4 0 2 2 0 014 0zM16 12a2 2 0 100-4 2 2 0 000 4z" />
                    </svg>
                  </button>
                </div>
              </div>
              <p className="text-gray-900 dark:text-white mb-4">{post.content}</p>
              <div className="flex items-center gap-6">
                <button className="flex items-center gap-2 text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400">
                  <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M2 10.5a1.5 1.5 0 113 0v6a1.5 1.5 0 01-3 0v-6zM6 10.333v5.43a2 2 0 001.106 1.79l.05.025A4 4 0 008.943 18h5.416a2 2 0 001.962-1.608l1.2-6A2 2 0 0015.56 8H12V4a2 2 0 00-2-2 1 1 0 00-1 1v.667a4 4 0 01-.8 2.4L6.8 7.933a4 4 0 00-.8 2.4z" />
                  </svg>
                  <span>Like {post.likes}</span>
                </button>
                <button className="flex items-center gap-2 text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400">
                  <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path fillRule="evenodd" d="M18 13V5a2 2 0 00-2-2H4a2 2 0 00-2 2v8a2 2 0 002 2h3l3 3 3-3h3a2 2 0 002-2zM5 7a1 1 0 011-1h8a1 1 0 110 2H6a1 1 0 01-1-1zm1 3a1 1 0 100 2h3a1 1 0 100-2H6z" clipRule="evenodd" />
                  </svg>
                  <span>Comment {post.comments}</span>
                </button>
                <button className="flex items-center gap-2 text-gray-700 hover:text-emerald-600 dark:text-gray-300 dark:hover:text-emerald-400">
                  <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" viewBox="0 0 20 20" fill="currentColor">
                    <path d="M15 8a3 3 0 10-2.977-2.63l-4.94 2.47a3 3 0 100 4.319l4.94 2.47a3 3 0 10.895-1.789l-4.94-2.47a3.027 3.027 0 000-.74l4.94-2.47C13.456 7.68 14.19 8 15 8z" />
                  </svg>
                  <span>Share</span>
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </main>
  );
}
