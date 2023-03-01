import * as ajax from "../../common/ajax";

export const get = id => ajax.get("/admin/course/" + id);

export const deleteItem = id => ajax.pureDelete("/admin/course/" + id);

export const getPageCount = (departmentName, majorName, name) =>
  ajax.get("/admin/course/page/count", {
    departmentName: departmentName,
    majorName: majorName,
    name: name
  });

export const getPage = (index, departmentName, majorName, name) =>
  ajax.get("/admin/course/page/" + index, {
    departmentName: departmentName,
    majorName: majorName,
    name: name
  });

export const listName = () => ajax.pureGet("/admin/course/names");

export const pageSize = 20;
