'use strict';

angular.module('finaltestApp').controller('DrinkRecipeDialogController',
    ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'DrinkRecipe', 'Ingredients',
        function($scope, $stateParams, $uibModalInstance, entity, DrinkRecipe, Ingredients) {

        $scope.drinkRecipe = entity;
        $scope.ingredientss = Ingredients.query();
        $scope.load = function(id) {
            DrinkRecipe.get({id : id}, function(result) {
                $scope.drinkRecipe = result;
            });
        };

        var onSaveSuccess = function (result) {
            $scope.$emit('finaltestApp:drinkRecipeUpdate', result);
            $uibModalInstance.close(result);
            $scope.isSaving = false;
        };

        var onSaveError = function (result) {
            $scope.isSaving = false;
        };

        $scope.save = function () {
            $scope.isSaving = true;
            if ($scope.drinkRecipe.id != null) {
                DrinkRecipe.update($scope.drinkRecipe, onSaveSuccess, onSaveError);
            } else {
                DrinkRecipe.save($scope.drinkRecipe, onSaveSuccess, onSaveError);
            }
        };

        $scope.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };
}]);
