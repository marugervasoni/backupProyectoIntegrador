import axios from "axios";
import config from "../config.json";

const headers = {
  "Access-Control-Allow-Origin": "*",
  Accept: "application/json",
  "Content-Type": "application/json",
};

async function login(username, password) {
  const response = await axios.post("/api/authenticate", {
    username,
    password,
  });
  const token = response.data.token;

  // Guardar el token en el almacenamiento local del navegador
  localStorage.setItem("token", token);
}

async function axiosApiPost(route, body, parameters = {}) {
  const bearerToken = localStorage.getItem("token");
  let response = {};
  if (bearerToken) headers.Authorization = `Bearer ${bearerToken}`;
  try {
    response = await axios.post(`${config.baseUrl}/${route}`, body, {
      headers,
      params: {
        ...parameters,
      },
    });
  } catch (error) {
    if (error?.response?.data?.error === "invalid_token") {
      sessionStorage.removeItem("BearerToken");
      response = await axiosApiPost(route, body);

      return response;
    }
    throw error?.response?.data;
  }
  return response;
}

async function axiosApiPut(route, body) {
  const bearerToken = localStorage.getItem("token");
  let response = {};
  if (bearerToken) headers.Authorization = `Bearer ${bearerToken}`;
  try {
    response = await axios.put(`${config.baseUrl}/${route}`, body, {
      headers,
    });
  } catch (error) {
    if (error?.response?.data?.error === "invalid_token") {
      sessionStorage.removeItem("BearerToken");
      response = await axiosApiPut(route, body);

      return response;
    }
    throw error?.response?.data;
  }
  return response;
}

async function axiosApiDelete(route, parameters = {}) {
  const bearerToken = localStorage.getItem("token");
  let response = {};
  if (bearerToken) headers.Authorization = `Bearer ${bearerToken}`;
  try {
    response = await axios.delete(`${config.baseUrl}/${route}`, {
      headers,
      params: {
        ...parameters,
      },
    });
  } catch (error) {
    if (error?.response?.data?.error === "invalid_token") {
      sessionStorage.removeItem("BearerToken");
      response = await axiosApiDelete(route);

      return response;
    }
    throw error?.response?.data;
  }

  return response;
}

async function axiosApiGet(route, parameters = {}) {
  const bearerToken = localStorage.getItem("token");
  let response = {};
  if (bearerToken) headers.Authorization = `Bearer ${bearerToken}`;
  try {
    response = await axios.get(`${config.baseUrl}/${route}`, {
      headers,
      params: {
        ...parameters,
      },
    });
  } catch (error) {
    if (error?.response?.data?.error === "invalid_token") {
      sessionStorage.removeItem("BearerToken");
      response = await axiosApiGet(route);

      return response;
    }
    throw error?.response?.data;
  }

  return response;
}

const apiService = {
  axiosApiDelete,
  axiosApiPost,
  axiosApiGet,
  axiosApiPut,
  login,
};
export default apiService;
