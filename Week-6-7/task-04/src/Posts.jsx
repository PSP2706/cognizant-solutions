// src/Posts.js
import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  // Method to fetch posts
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Failed to fetch posts');
        }
        return response.json();
      })
      .then((data) => {
        this.setState({ posts: data });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  };

  // Lifecycle hook
  componentDidMount() {
    this.loadPosts();
  }

  // Error boundary method
  componentDidCatch(error, info) {
    alert('An error occurred: ' + error.message);
  }

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Posts</h2>
        {this.state.posts.map((post) => (
          <div key={post.id} style={{ marginBottom: '20px' }}>
            <h3>{post.title}</h3>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
