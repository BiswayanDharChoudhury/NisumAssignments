import React from 'react';
import './UserProfileNew.css';

const UserProfileNew = ({ name, email, avatarUrl, bio }) => {
  const defaultAvatar = 'https://via.placeholder.com/100';

  return (
    <div className="user-card">
      <img src={avatarUrl || defaultAvatar} alt={name} className="avatar" />
      <div className="user-info">
        <h3>{name}</h3>
        <p>{email}</p>
        <p>{bio}</p>
      </div>
    </div>
  );
};

UserProfileNew.defaultProps = {
  name: 'John Doe',
  email: 'john@example.com',
  bio: 'This user prefers to stay mysterious.',
  avatarUrl: ''
};

export default UserProfileNew;
