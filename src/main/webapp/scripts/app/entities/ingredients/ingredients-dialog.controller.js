'use strict';

angular.module('finaltestApp').controller('IngredientsDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Ingredients', 'Unitofmeasure', 'Drinkrecipe',
        function($scope, $stateParams, $uibModalInstance, entity, Ingredients, Unitofmeasure, Drinkrecipe) {

        $scope.ingredients = entity;
        $scope.unitofmeasures = Unitofmeasure.query();
        $scope.drinkrecipes = Drinkrecipe.query();
        $scope.load = function(id) {
            Ingredients.get({id : id}, function(result) {
                $scope.ingredients = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:ingredientsUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.ingredients.id != null) {
                Ingredients.update($scope.ingredients, onSaveSuccess, onSaveError);
            } else {
                Ingredients.save($scope.ingredients, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
