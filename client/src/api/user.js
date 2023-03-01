import { post, pureGet } from "../common/ajax";

export const login = (swnumber, password, userType) =>
  post("/user/login", {
    swnumber: swnumber,
    password: password,
    userType: userType
  });

export const getLoginStatus = () => pureGet("/user/login/status");

export const logout = () => pureGet("/user/logout");
