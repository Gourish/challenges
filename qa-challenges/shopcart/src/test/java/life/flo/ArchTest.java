package life.flo;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("life.flo");

        noClasses()
            .that()
                .resideInAnyPackage("life.flo.service..")
            .or()
                .resideInAnyPackage("life.flo.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..life.flo.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
