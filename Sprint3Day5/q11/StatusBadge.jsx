import React from 'react';
import classNames from 'classnames';
import './StatusBadge.css';

const StatusBadge = ({ status }) => {
  const badgeClass = classNames('badge', {
    'badge-success': status === 'success',
    'badge-error': status === 'error',
    'badge-warning': status === 'warning',
  });

  return (
    <span className={badgeClass}>
      {status ? status.toUpperCase() : 'UNKNOWN'}
    </span>
  );
};

export default StatusBadge;
