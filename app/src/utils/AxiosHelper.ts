import axios, { type AxiosRequestConfig } from 'axios';

const api = axios.create({
  timeout: 50000,
  baseURL: 'http://localhost:8080',
});

export async function fetcher<T>(
  url: string,
  config?: AxiosRequestConfig
): Promise<T> {
  const response = await api.get(url, config);
  return response.data as T;
}

export async function poster<TData, TResponse = TData>(
  url: string,
  data?: TData,
  config?: AxiosRequestConfig<TData>
): Promise<TResponse> {
  const response = await api.post(url, data, config);
  return response.data as TResponse;
}

export async function patcher<TData, TResponse = TData>(
  url: string,
  data?: TData
): Promise<TResponse> {
  const response = await api.patch(url, data);
  return response.data as TResponse;
}

export async function putter<TData, TResponse = TData>(
  url: string,
  data: TData
): Promise<TResponse> {
  const response = await api.put(url, data);
  return response.data as TResponse;
}

export async function deleter<TData, TResponse = void>(
  url: string,
  data?: TData
): Promise<TResponse> {
  const response = await api.delete(url, { data });
  return response.data as TResponse;
}

export default api;
