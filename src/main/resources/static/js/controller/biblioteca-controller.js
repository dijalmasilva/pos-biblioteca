/**
 * Created by dijalmasilva on 19/10/17.
 */

var app = angular.module("biblioteca-app");

app.controller("BibliotecaController", ["$scope", "BibliotecaService", function ($scope, BibliotecaService) {

    //tab = 1 --> Novo autor
    //tab = 2 --> Listar autores
    //tab = 3 --> Novo livro
    //tab = 4 --> Listar livros
    //tab = 5 --> Editar Autor
    //tab = 6 --> Editar Livro
    $scope.tab = 0;
    $scope.livro = {};
    $scope.autor = {};

    $scope.setTab = function (tab) {
        if (tab === null || tab === "") {
            tab = 0;
        } else if (tab === 2 || tab === 6) {
            $scope.listarAutores();
        } else if (tab === 3) {
            $scope.livro.autores = [];
            $scope.listarAutores();
        }
        else if (tab === 4) {
            $scope.listarLivros();
        }

        $scope.tab = tab;
    };

    $scope.compareTab = function (tab) {
        return tab === $scope.tab;
    };

    $scope.isInclude = function (idAutor) {
        var autor = {};
        for (var i = 0; i < $scope.livro.autores; i++) {
            autor = $scope.livro.autores[i];
            if (autor.id === idAutor) {
                return true;
            }
        }
        return false;
    };

    $scope.adicionarAutor = function (autor) {
        $scope.livro.autores.push(autor);
    };

    $scope.removerAutor = function (autor) {
        var autores = $scope.livro.autores;
        $scope.livro.autores = autores.filter(function (e) {
            return e.id !== autor.id;
        });
    };

    $scope.salvarAutor = function () {
        BibliotecaService.salvarAutor($scope.autor, function (res) {
            alert(res.statusText);
            console.log(res);
            if (res.status === 201) {
                $scope.autor = {};
            }
        });
    };

    $scope.salvarLivro = function () {
        BibliotecaService.salvarLivro($scope.livro, function (res) {
            alert(res.statusText);
            console.log(res);
            if (res.status === 201) {
                $scope.livro = {};
            }
        });
    };

    $scope.listarAutores = function () {
        BibliotecaService.listarAutores(function (res) {
            $scope.autores = res.data;
        })
    };

    $scope.listarLivros = function () {
        BibliotecaService.listarLivros(function (res) {
            $scope.livros = res.data;
        })
    };

    $scope.edicaoAutor = function (autor) {
        $scope.autor = autor;
        $scope.setTab(5);
    };

    $scope.editarAutor = function () {
        BibliotecaService.editarAutor($scope.autor, function (res) {
            alert(res.statusText);
            console.log(res);
            if (res.status === 200) {
                $scope.autor = {};
                $scope.setTab(2);
            }
        })
    };

    $scope.edicaoLivro = function (livro) {
        $scope.livro = livro;
        $scope.setTab(6);
    }

    $scope.editarLivro = function () {
        BibliotecaService.editarLivro($scope.livro, function (res) {
            alert(res.statusText);
            console.log(res);
            if (res.status === 200) {
                $scope.livro = {};
                $scope.setTab(4);
            }
        })
    }

    $scope.removerLivro = function (idLivro) {
        BibliotecaService.deletarLivro(idLivro, function (res) {
            console.log(res);
            $scope.setTab(4);
        })
    }

    $scope.deletarAutor = function (idAutor) {
        BibliotecaService.deletarAutor(idAutor, function (res) {
            console.log(res);
            $scope.setTab(2);
        })
    }

    $scope.cancelar = function () {
        $scope.tab = 0;
        $scope.livro = {};
        $scope.autor = {};
    }
}]);