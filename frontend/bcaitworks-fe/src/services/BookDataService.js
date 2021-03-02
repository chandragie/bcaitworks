import http from "../http-common";

class BookDataService {
  getBooks() {
    return http.get("/book");
  }
}

export default new BookDataService();
