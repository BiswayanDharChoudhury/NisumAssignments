import React from 'react';
import './NotificationsNew.css';

const NotificationsNew = ({ notifications }) => {
  return (
    <div className="notifications">
      <h3>Notifications</h3>
      {notifications.map((note, index) => (
        <div key={index} className={`notification ${note.read ? 'read' : 'unread'}`}>
          <p><strong>{note.message}</strong></p>
          <p>{note.date} – {note.time}</p>
          <p>Status: {note.read ? 'Read' : 'Unread'}</p>
        </div>
      ))}
    </div>
  );
};

NotificationsNew.defaultProps = {
  notifications: [
    { message: 'New assignment uploaded', date: '2025-06-16', time: '10:30 AM', read: false },
    { message: 'Meeting at 2 PM', date: '2025-06-15', time: '1:00 PM', read: true }
  ]
};

export default NotificationsNew;
