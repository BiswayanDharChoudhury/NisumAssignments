import React from "react";

function withAdminAccess(WrappedComponent) {
  return function (props) {
    const { user } = props;
    if (!user || user.role !== "admin") {
      return <div>Access Denied: Admins Only</div>;
    }
    return <WrappedComponent {...props} />;
  };
}

export default withAdminAccess;
