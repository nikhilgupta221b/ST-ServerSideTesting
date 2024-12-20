// import axios from "axios";
// import { getToken } from "../auth";

// export const BASE_URL = "http://localhost:9090/api/v1";
// // export const BASE_URL = "https://apis.lcwdblogs.online/api/v1";

// export const myAxios = axios.create({
//   baseURL: BASE_URL,
// });

// export const privateAxios = axios.create({
//   baseURL: BASE_URL,
// });

// privateAxios.interceptors.request.use(
//   (config) => {
//     const token = getToken();

//     if (token) {
//       config.headers.common.Authorization = `Bearer ${token}`;
//       // console.log(config);
//     }

//     return config;
//   },
//   (error) => Promise.reject(error)
// );

import axios from "axios";
import { getToken } from "../auth";

export const BASE_URL = "http://localhost:8080/api";
// export const BASE_URL = "https://apis.lcwdblogs.online/api/v1";

export const myAxios = axios.create({
  baseURL: BASE_URL,
});

export const privateAxios = axios.create({
  baseURL: BASE_URL,
});

privateAxios.interceptors.request.use(
  (config) => {
    const token = getToken();

    if (token) {
      if (!config.headers) {
        config.headers = {};
      }
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => Promise.reject(error)
);
