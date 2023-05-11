import apiService from "./apiService";

async function getAllCategories() {
  const response = await apiService.axiosApiGet("categories");
  console.log({ response });
  return response.data.data;
}

async function getCategoryById(id) {
  const response = await apiService.axiosApiGet(`categories/${id}`);

  return response.data.data;
}

async function createNewCategory(newCategory) {
  const response = await apiService.axiosApiPost(
    `categories/create`,
    newCategory
  );

  return response.data;
}
async function updateCategory(category) {
  const response = await apiService.axiosApiPost(
    `categories/update/${category.id}`,
    category
  );

  return response.data;
}

async function deleteCategory(id) {
  const response = await apiService.axiosApiPost(`categories/update/${id}`);

  return response.data;
}

const categoryService = {
  getAllCategories,
  getCategoryById,
  createNewCategory,
  updateCategory,
  deleteCategory,
};

export default categoryService;
