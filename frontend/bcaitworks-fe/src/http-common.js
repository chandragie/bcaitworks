import axios from "axios";

const http = () => {
  const defaultOptions = {
    baseURL: "http://localhost:8080",
    headers: {
      'Content-Type': 'application/json'
    },
  };

  // Create instance
  let instance = axios.create(defaultOptions);

  // Set the AUTH token for any request
  instance.interceptors.request.use(function (config) {
    const token = JSON.parse(localStorage.getItem('token'));
    config.headers.Authorization = token ? token : '';
    return config;
  });

  return instance;
};

export default http();