import * as ajax from "../../common/ajax";

export const get = () => ajax.pureGet("/teacher/info");

export const update = entity => ajax.put("/teacher/info", entity);
