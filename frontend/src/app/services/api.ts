const API_BASE_URL = 'http://localhost:8080/api';

interface Post {
  id?: number;
  content: string;
  authorName?: string;
  isAnonymous: boolean;
  likeCount?: number;
  createdAt?: string;
  mediaUrls?: string[];
  user: {
    id: number;
  };
}

const defaultHeaders = {
  'Content-Type': 'application/json',
  'Accept': 'application/json',
};

export const createPost = async (postData: Post): Promise<Post> => {
  try {
    const response = await fetch(`${API_BASE_URL}/posts`, {
      method: 'POST',
      headers: defaultHeaders,
      body: JSON.stringify(postData),
      credentials: 'include',
    });

    if (!response.ok) {
      const errorData = await response.json().catch(() => ({}));
      throw new Error(errorData.message || 'Failed to create post');
    }

    return response.json();
  } catch (error) {
    console.error('Error creating post:', error);
    throw error;
  }
};

export const getAllPosts = async (): Promise<Post[]> => {
  try {
    const response = await fetch(`${API_BASE_URL}/posts`, {
      method: 'GET',
      headers: defaultHeaders,
      credentials: 'include',
    });
    
    if (!response.ok) {
      const errorData = await response.json().catch(() => ({}));
      throw new Error(errorData.message || 'Failed to fetch posts');
    }

    return response.json();
  } catch (error) {
    console.error('Error fetching posts:', error);
    throw error;
  }
};

export const likePost = async (postId: number): Promise<Post> => {
  try {
    const response = await fetch(`${API_BASE_URL}/posts/${postId}/like`, {
      method: 'POST',
      headers: defaultHeaders,
      credentials: 'include',
    });

    if (!response.ok) {
      const errorData = await response.json().catch(() => ({}));
      throw new Error(errorData.message || 'Failed to like post');
    }

    return response.json();
  } catch (error) {
    console.error('Error liking post:', error);
    throw error;
  }
}; 