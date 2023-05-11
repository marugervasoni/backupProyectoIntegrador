import { useState, useEffect } from "react";

const useFetch = (service, defaultValue = null) => {
  const [data, setData] = useState(defaultValue);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await service();
        setData(response);
      } catch (error) {
        setError(error);
      }
      setLoading(false);
    };
    fetchData();
  }, [service]);

  return { data, loading, error };
};

export { useFetch };
