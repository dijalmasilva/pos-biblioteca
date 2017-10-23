/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("biblioteca-app");

app.service("BibliotecaService", ["$http", function ($http) {

    var urlLivro = "http://localhost:8081/livro";
    var urlAutor = "http://localhost:8081/autor";

    this.salvarAutor = function (autor, callback) {

        $http.post(urlAutor, autor).then(function (res) {
            res.statusText = "Autor cadastrado com sucesso!";
            callback(res);
        }, function (res) {
            res.statusText = "Erro ao cadastrar autor!";
            callback(res);
        });
    };

    this.salvarLivro = function (livro, callback) {

        $http.post(urlLivro, livro).then(function (res) {
            res.statusText = "Livro cadastrado com sucesso!";
            callback(res);
        }, function (res) {
            res.statusText = "Erro ao cadastrar Livro!";
            callback(res);
        });
    };

    this.listarAutores = function (callback) {
        $http.get(urlAutor).then(function (res) {
            callback(res);
        })
    };

    this.listarLivros = function (callback) {
        $http.get(urlLivro).then(function (res) {
            callback(res);
        })
    };

    this.editarAutor = function (autor, callback) {
        $http.put(urlAutor + "/" + autor.id, autor).then(function (res) {
            res.statusText = "Autor editado com sucesso!";
            callback(res);
        }, function (res) {
            res.statusText = "Erro ao editar autor!";
            callback(res);
        });
    }

    this.deletarAutor = function (idAutor, callback) {
        $http.delete(urlAutor + "/" + idAutor).then(function (res) {
            callback(res);
        });
    }

    this.editarLivro = function (livro, callback) {
        $http.put(urlLivro + "/" + livro.id, livro).then(function (res) {
            res.statusText = "Livro editado com sucesso!";
            callback(res);
        }, function (res) {
            res.statusText = "Erro ao editar livro!";
            callback(res);
        })
    }

    this.deletarLivro = function (idLivro, callback) {
        $http.delete(urlLivro + "/" + idLivro).then(function (res) {
            callback(res);
        });
    }

}]);