using System.IO;
using System.Reflection;
using System.Configuration;
using log4net;
using log4net.Config;
using log4net.Repository.Hierarchy;

namespace WebUITestFramework
{
    public static class LogHelper
    {
        /// <summary>
        /// Configures Log4Net at the time of loading the test assembly.
        /// Log Appenders are configured in the log4net.config file
        /// </summary>
        public static void ConfigureLogging()
        {
            // Initialize Log4Net
            //log4net.Util.LogLog.InternalDebugging = true;
            Configuration config = ConfigurationManager.OpenExeConfiguration(Assembly.GetExecutingAssembly().Location);
            XmlConfigurator.Configure(new FileInfo(config.FilePath));
            ILog Logger = LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);
            Logger.Debug("Logging Initialized.");
        }

        public static void ChangeLogLevel(log4net.Core.Level logLevel)
        {
            Hierarchy hierarchy = (Hierarchy)LogManager.GetRepository();
            hierarchy.Root.Level = logLevel;
            hierarchy.RaiseConfigurationChanged(System.EventArgs.Empty);
        }
    }
}
