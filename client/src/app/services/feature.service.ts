import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

const baseUrl = "http://localhost:8086/api";

@Injectable({
  providedIn: "root",
})
export class FeatureService {
  constructor(private http: HttpClient) {}

  getAll() {
    return this.http.get(`${baseUrl}/features`);
  }

  get(id) {
    return this.http.get(`${baseUrl}/feature/${id}`);
  }

  create(data) {
    return this.http.post(`${baseUrl}/feature`, data);
  }

  update(id, data) {
    return this.http.put(`${baseUrl}/feature/update`, data);
  }

  delete(id) {
    return this.http.delete(`${baseUrl}/feature/${id}`);
  }

  deleteAll() {
    return this.http.delete(baseUrl);
  }

  findByTitle(title) {
    return this.http.get(`${baseUrl}?title=${title}`);
  }
}
