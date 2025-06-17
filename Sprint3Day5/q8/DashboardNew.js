import React from 'react';
import UserProfileNew from './UserProfileNew';
import NotificationsNew from './NotificationsNew';

const DashboardNew = () => {
  const user = {
    name: 'Biswayan Dhar',
    email: 'biswayan@example.com',
    bio: 'Frontend developer passionate about React.',
    avatarUrl: ''
  };

  const notifications = [
    { message: 'Project deadline extended', date: '2025-06-15', time: '09:00 AM', read: true },
    { message: 'New feedback received', date: '2025-06-16', time: '11:00 AM', read: false }
  ];

  return (
    <div>
      <h2>Dashboard</h2>
      <UserProfileNew 
        name={user.name}
        email={user.email}
        bio={user.bio}
        avatarUrl={user.avatarUrl}
      />
      <NotificationsNew notifications={notifications} />
    </div>
  );
};

export default DashboardNew;
