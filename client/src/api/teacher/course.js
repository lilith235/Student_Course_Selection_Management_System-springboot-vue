import * as ajax from "../../common/ajax";

export const list = () => ajax.pureGet("/teacher/course/list");

export const create = entity => ajax.post("/teacher/course", entity);